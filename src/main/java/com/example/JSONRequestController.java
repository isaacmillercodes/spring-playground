package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONRequestController {
    @PostMapping("/wrestlers")
    public String getJSONWrestler(@RequestBody WrestlerData wrestler) {
        return wrestler.getFinishingMove();
    }

    static class Donut {
        private String id;
        private String name;
        private Topping[] toppings;

        public String getId() { return id;}
        public void setId(String id) { this.id = id; }

        public String getName() { return name;}
        public void setName(String name) { this.name = name; }

        public Topping[] getToppings() { return toppings;}
        public void setToppings(Topping[] toppings) { this.toppings = toppings; }

    }

    static class Topping {
        private String id;
        private String type;

        public String getId() { return id;}
        public void setId(String id) { this.id = id; }

        public String getType() { return type;}
        public void setType(String type) { this.type = type; }
    }

    @PostMapping("/donuts")
    public String getJSONDonuts(@RequestBody Donut donut) {
        return donut.toppings[0].getType();
    }
}
