//import static spark.Spark.*;
//
//public class App {
//    public static void main(String[] args) {
//        get("/hello", (request, response) -> "Hello Friend!");
//    }
//}

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

     staticFileLocation("/public");
//
//        get("/", (request, response) -> {
//            return new ModelAndView(new HashMap(), "hello.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/favorite_photos", (request, response) -> {
//            return new ModelAndView(new HashMap(), "favorite_photos.hbs");
//        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            //request for route happens at this location
            Map<String, Object> model = new HashMap<String, Object>();
            // new model is made to store information
            return new ModelAndView(model, "hello.hbs");
            // assemble individual pieces and render
        }, new HandlebarsTemplateEngine());
        //

        get("/favorite_photos", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "favorite_photos.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> { //request for route happens at this location
            Map<String, Object> model = new HashMap<String, Object>(); // new model is made to store information
            return new ModelAndView(model, "hello.hbs"); // assemble individual pieces and render
        }, new HandlebarsTemplateEngine());
        //
        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());


        get("/greeting_card", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String recipient = request.queryParams("recipient");
            String sender = request.queryParams("sender");
            model.put("recipient", recipient);
            model.put("sender", sender);
            return new ModelAndView(model, "greeting_card.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

//                "<!DOCTYPE html>" +
//                        "<html>" +
//                        "<head>" +
//                        "<title>Hello Friend!</title>" +
//                        "<link rel='stylesheet' + href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
//                        "</head>" +
//                        "<body>" +
//                        "<h1>Hello From Afar</h1>" +
//                        "<p>Dear Friend,</p>" +
//                        "<p>How are you? I hope that you are having a nice weekend. I'm vacationing in the Iceland while I learn programming! </p>" +
//                        "<p>Friend, you would not believe how cold it is here. I should have gone to Hawaii instead.</p>" +
//                        "<p>But I like programming a lot, so I've got that going for me. </p>" +
//                        "<p>Looking forward to seeing you soon. I'll bring you back a souvenir. </p>" +
//                        "<p>Cheers,</p>" +
//                        "<p>Travel Enthusiast Jane</p>" +
//
//                        "<p><a href='/favorite_photos' >P.S. Check out my favorite travel photos here.</a></p>" +
//                        "</body>" +
//                        "</html>"
//        );

//        get("/favorite_photos", (request, response) ->
//                "<!DOCTYPE html>" +
//                        "<html>" +
//                        "<head>" +
//                        "<title>Hello Friend!</title>" +
//                        "<link rel='stylesheet'  href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
//                        "</head>" +
//                        "<body>" +
//                        "<h1>Favorite Traveling Photos</h1>" +
//                        "<ul>" +
//                        "<li><img src='/images/foggymountain.jpeg' alt='A photo of a mountain.'/></li>" +
//                        "<li><img src='/images/rocky.jpeg' alt='A photo of a a rocky beach.'/></li>" +
//                        "</ul>" +
//                        "</body>" +
//                        "</html>"
//        );
//    }
//}