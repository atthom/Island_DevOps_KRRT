
import eu.ace_design.island.mvp.Explorer;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Greeter g = new Greeter();

        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        System.out.print(obj.get("balance"));

        String contract = "{ \n"
                + "  \"men\": 12,\n"
                + "  \"budget\": 10000,\n"
                + "  \"contracts\": [\n"
                + "    { \"amount\": 600, \"resource\": \"WOOD\" },\n"
                + "    { \"amount\": 200, \"resource\": \"GLASS\" }\n"
                + "  ],\n"
                + "  \"heading\": \"W\"\n"
                + "}";
        Explorer e = new Explorer();
        e.initialize(contract);

        // Gerer le parsing des informations lie a l'action fly

        String test = "{ \n"
                + "  \"cost\": 1,\n"
                + "  \"extras\": \n"
                + "    { \"range\": 2, \"found\": \"GROUND\" }, \n"
                + " \"status\": \"OK\" \n"
                + "}";
    }
}
