package org.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

// Which marks the class as a controller where every method returns a domain object instead of a view.
@RestController
public class Controller {

    private static final String template = "Hello";
    private final AtomicLong greetingCounter = new AtomicLong();
//    private final AtomicLong poopCounter = new AtomicLong();
    private final Map<String, String> bearImages = new HashMap<String, String>();

    /**
     * The constructor initializes the GreetingController with a map of bear images and their respective photographers.
     * It populates the map with 58 bear image URLs and their photographer names.
     */
    public Controller() {
        bearImages.put("/images/bears/1.jpg", "Janko Ferlič");
        bearImages.put("/images/bears/2.jpg", "Janko Ferlič");
        bearImages.put("/images/bears/3.jpg", "Janko Ferlič");
        bearImages.put("/images/bears/4.jpg", "Pete Nuij");
        bearImages.put("/images/bears/5.jpg", "Mohamed Elsayed");
        bearImages.put("/images/bears/6.jpg", "Ben Owen");
        bearImages.put("/images/bears/7.jpg", "Mark Basarab");
        bearImages.put("/images/bears/8.jpg", "Leila Boujnane");
        bearImages.put("/images/bears/9.jpg", "Zdeněk Macháček");
        bearImages.put("/images/bears/10.jpg", "Ali Rizvi");
        bearImages.put("/images/bears/11.jpg", "Anthony Renovato");
        bearImages.put("/images/bears/12.jpg", "Pietro Donà");
        bearImages.put("/images/bears/13.jpg", "Alexandru-Bogdan Ghita");
        bearImages.put("/images/bears/14.jpg", "Paxson Woelber");
        bearImages.put("/images/bears/15.jpg", "Tarryn Grignet");
        bearImages.put("/images/bears/16.jpg", "Sneha Chandrashekar");
        bearImages.put("/images/bears/17.jpg", "Greg Johnson");
        bearImages.put("/images/bears/18.jpg", "Margaret Strickland");
        bearImages.put("/images/bears/19.jpg", "Ars Gadz");
        bearImages.put("/images/bears/20.jpg", "Bobby Mc Leod");
        bearImages.put("/images/bears/21.jpg", "Thomas Lipke");
        bearImages.put("/images/bears/22.jpg", "mana5280");
        bearImages.put("/images/bears/23.jpg", "Rey Emsen");
        bearImages.put("/images/bears/24.jpg", "Federico Artusi");
        bearImages.put("/images/bears/25.jpg", "Olen Gandy");
        bearImages.put("/images/bears/26.jpg", "Bob Brewer");
        bearImages.put("/images/bears/27.jpg", "Fabe Collage");
        bearImages.put("/images/bears/28.jpg", "Sergey Koop");
        bearImages.put("/images/bears/29.jpg", "Taylor Wright");
        bearImages.put("/images/bears/30.jpg", "II Vagabiondo");
        bearImages.put("/images/bears/31.jpg", "Denise Jans");
        bearImages.put("/images/bears/32.jpg", "J-Photos");
        bearImages.put("/images/bears/33.jpg", "Carol Highsmith's America");
        bearImages.put("/images/bears/34.jpg", "Olen Gandy");
        bearImages.put("/images/bears/35.jpg", "Oleksandr Sushko");
        bearImages.put("/images/bears/36.jpg", "Ben Owen");
        bearImages.put("/images/bears/37.jpg", "Vojtěch Jaňour");
        bearImages.put("/images/bears/38.jpg", "Sergey Koop");
        bearImages.put("/images/bears/39.jpg", "Pete Nuij");
        bearImages.put("/images/bears/40.jpg", "Anna Tremewan");
        bearImages.put("/images/bears/41.jpg", "Daniela Kalwarowskyj");
        bearImages.put("/images/bears/42.jpg", "Suzanne Rushton");
        bearImages.put("/images/bears/43.jpg", "Cristina Glebova");
        bearImages.put("/images/bears/44.jpg", "Cristina Glebova");
        bearImages.put("/images/bears/45.jpg", "Cristina Glebova");
        bearImages.put("/images/bears/46.jpg", "Cristina Glebova");
        bearImages.put("/images/bears/47.jpg", "Cristina Glebova");
        bearImages.put("/images/bears/48.jpg", "Joseph Stalin");
        bearImages.put("/images/bears/49.jpg", "Kushagra Saxena");
        bearImages.put("/images/bears/50.jpg", "Anna Zhynhel");
        bearImages.put("/images/bears/51.jpg", "mana5280");
        bearImages.put("/images/bears/52.jpg", "Jordi Vich Navarro");
        bearImages.put("/images/bears/53.jpg", "mana5280");
        bearImages.put("/images/bears/54.jpg", "mana5280");
        bearImages.put("/images/bears/55.jpg", "mana5280");
        bearImages.put("/images/bears/56.jpg", "mana5280");
        bearImages.put("/images/bears/57.jpg", "mana5280");
        bearImages.put("/images/bears/58.jpg", "Nidal Shbeeb");
    }

    // Endpoint to greet a user by name. If no name is provided, defaults to "World".
    // The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(greetingCounter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/rawr")
    public BearImage bearImage() {
        // Generate a random integer between 1 and 57 (inclusive) to select a bear image from the map.
        int randomInt = (int) (Math.random() * 58) + 1;
        String randomBearPath = "/images/bears/" + randomInt + ".jpg";
        String photographerName = bearImages.get(randomBearPath);
        String randomBearURL = "http://localhost:8080/images/bears/" + randomInt + ".jpg";

        // Print out previous values for debugging
        System.out.println("randomInt: " + randomInt);
        System.out.println("randomBearURL: " + randomBearURL);
        System.out.println("photographerName: " + photographerName);

        //return randomBearURL;
        return new BearImage(randomBearURL, photographerName);
    }

    @GetMapping("/rawr.json")
    public BearImage bearJSON() {
        // Generate a random integer between 1 and 58 (inclusive) to select a bear image from the map.
        int randomInt = (int) (Math.random() * 58) + 1;
        String randomBearPath = "/images/bears/" + randomInt + ".jpg";
        String photographerName = bearImages.get(randomBearPath);
        String randomBearURL = "http://localhost:8080/images/bears/" + randomInt + ".jpg";

        // Print out previous values for debugging
        System.out.println("randomInt: " + randomInt);
        System.out.println("randomBearURL: " + randomBearURL);
        System.out.println("photographerName: " + photographerName);

        //return randomBearURL;
        return new BearImage(randomBearURL, photographerName);
    }

    @GetMapping("/floofs")
    public Map<String, String> bearFloofs() {
        return bearImages;
    }

    @GetMapping("/floofs/count")
    public int getFloofCount() {
        return bearImages.size();
    }

//    @GetMapping("/create-sentence")
//    public Poop poop(@RequestParam(value = "first", defaultValue = "create") String word1,
//                     @RequestParam(value = "second", defaultValue = "sentence!") String word2) {
//        return new Poop(poopCounter.incrementAndGet(), String.format(template, word1, word2));
//    }

//    @GetMapping("/number")
//    public Poop poop(@RequestParam(value = "type", defaultValue = randomInt) int randNumber) {
//        return new Poop(poopCounter.incrementAndGet(), String.format(template, name));
//    }
}
