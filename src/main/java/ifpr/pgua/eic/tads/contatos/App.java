package ifpr.pgua.eic.tads.contatos;

import ifpr.pgua.eic.tads.contatos.controllers.AddController;
import ifpr.pgua.eic.tads.contatos.controllers.IndexController;
import ifpr.pgua.eic.tads.contatos.model.Agenda;
import ifpr.pgua.eic.tads.contatos.utils.JavalinUtils;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Javalin app = JavalinUtils.makeApp(8080);
        
        Agenda agenda = new Agenda();
        IndexController indexController = new IndexController();
        AddController addController = new AddController(agenda);

        app.get("/",indexController.get);
        app.get("/add",addController.get);
        app.post("/add",addController.post);
        
    }
}
