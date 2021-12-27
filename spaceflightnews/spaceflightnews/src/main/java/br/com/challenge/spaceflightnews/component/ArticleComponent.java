package br.com.challenge.spaceflightnews.component;

import br.com.challenge.spaceflightnews.controller.ArticleController;
import br.com.challenge.spaceflightnews.controller.EventController;
import br.com.challenge.spaceflightnews.controller.LauncheController;
import br.com.challenge.spaceflightnews.domain.Article;
import br.com.challenge.spaceflightnews.domain.Event;
import br.com.challenge.spaceflightnews.domain.Launche;
import br.com.challenge.spaceflightnews.log.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;

@Component
@EnableScheduling
public class ArticleComponent {


    @Autowired
    ArticleController articleController;

    @Autowired
    LauncheController launcheController;

    @Autowired
    EventController eventController;

    @Scheduled(cron = "0 0 09 * * *", zone = "America/Sao_Paulo")
    public void showNewArticles() throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        try{
            ArrayList<Article> articles = restTemplate.getForObject("https://api.spaceflightnsapi.net/v3/articles", ArrayList.class);
            transformJsonForObject(articles);
        } catch (Exception e) {
            new Log().createLog(e.toString());
        }

    }


    public void transformJsonForObject(ArrayList<Article> articles) throws JSONException {

        JSONArray jsonArray = new JSONArray(articles);

        for (int i = 0; i < jsonArray.length(); i++) {

            Launche launche = null;
            Event event = null;

            JSONObject jsonObject = jsonArray.getJSONObject(i);

            JSONArray jsonArrayLaunches = jsonObject.getJSONArray("launches");
            JSONArray jsonArrayEvents = jsonObject.getJSONArray("events");

            if (jsonArrayLaunches.length() > 0) {

                jsonObject = jsonArrayLaunches.getJSONObject(0);
                launche = new Launche(jsonObject.getString("id"), jsonObject.getString("provider"));
                launcheController.postLaunche(launche);
            }

            if (jsonArrayEvents.length() > 0) {

                jsonObject = jsonArrayEvents.getJSONObject(0);
                event = new Event(jsonObject.getString("id"), jsonObject.getString("provider"));
                eventController.postEvent(event);
            }

            jsonObject = jsonArray.getJSONObject(i);
            articleController.postArticle(new Article(jsonObject.getInt("id"), jsonObject.getString("title"), jsonObject.getString("url"), jsonObject.getString("imageUrl"), jsonObject.getString("newsSite"), jsonObject.getString("summary"), jsonObject.getString("publishedAt"), jsonObject.getString("updatedAt"), jsonObject.getBoolean("featured"), launche, event));

        }

    }


}
