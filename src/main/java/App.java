import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
	public static void main(String[] args) {
		staticFileLocation("/public");
		String layout = "templates/layout.vtl";

		get("/", (request, response) -> {
           Map<String, Object> model = new HashMap<String, Object>();
           model.put("stylists", Stylist.all());
           model.put("template", "templates/index.vtl");
           return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

		get("stylists/:id/clients/new", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
			model.put("stylist", stylist);
			model.put("template", "templates/stylist-clients-form.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		get("/clients", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("clients", Client.all());
			model.put("template", "templates/clients.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
         
        /*
		post("/clients", (request, response) -> {
           Map<String, Object> model = new HashMap<String, Object>();
           Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("stylistId")));
           String name = request.queryParams("name");
           Stylist newStylist = new Stylist(name, stylist.getId());
           model.put("stylist", stylist);
           model.put("template", "templates/stylist-clients-success.vtl");
           return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());
       */
       

		get("/clients/:id", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			Client client = Client.find(Integer.parseInt(request.params(":id")));
			model.put("client", client);
			model.put("template", "template/client.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

         // Category Stylist creation
		get("/stylists/new", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("template", "templates/stylit-form.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
        
        // Posting the Stylists into the app
		post("/stylists", (request, response) -> {
           Map<String, Object> model = new HashMap<String, Object>();
           String name = request.queryParams("name");
           Stylist newStylist = new Stylist(name);
           model.put("template", "templates/stylist-success.vtl");
           return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
         
         // Listing all the Stylists
		get("/stylists", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("stylists", Stylist.all());
			model.put("template", "templates/stylists.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		// Stylists ids
		get("stylists/:id", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
			model.put("stylist", stylist);
			model.put("template", "templates/stylist.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
        
       post("/clients", (request, response) -> {
           Map<String, Object> model = new HashMap<String, Object>();

          Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("stylistId")));

          String name = request.queryParams("name"); // Saving user inputted hero name into a String
          Stylist newStylist = new Stylist(name); // Squad constructorcreating new squad with the user's provided name
          request.session().attribute("stylist", "newStylist"); // We then save the squad object into the user's session

          stylist.addClient(newStylist);

          model.put("stylist", stylist);
          model.put("template", "templates/stylist-clients-success.vtl");
          return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
	}
}