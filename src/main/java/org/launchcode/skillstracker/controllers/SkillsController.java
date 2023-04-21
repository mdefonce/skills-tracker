package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class SkillsController {

    @GetMapping
    public String intro() {
        return "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                    "<li>Java</li>" +
                    "<li>JavaScript</li>" +
                    "<li>Python</li>" +
                "</ol>";
    }

    @PostMapping("form-results")
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloFormSubmit(@RequestParam String name, @RequestParam String language1, @RequestParam String language2, @RequestParam String language3) {
        String faveList = SkillsController.createMessage(language1, language2, language3);
        return "<h1>" + name + "</h1>" +
                faveList;
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form method = 'post' action = '/form-results'>" + // submit a request to /form
                "Name:<br>" +
                "<input type = 'text' name = 'name' ><br>" +
                "My favorite language:<br>" +
                "<select name='language1'>" +
                "    <option value='Java'>Java</option>" +
                "    <option value='JavaScript'>JavaScript</option>" +
                "    <option value='Python'>Python</option>" +
                "</select><br>" +
                "My second favorite language:<br>" +
                "<select name='language2'>" +
                "    <option value='Java'>Java</option>" +
                "    <option value='JavaScript'>JavaScript</option>" +
                "    <option value='Python'>Python</option>" +
                "</select><br>" +
                "My third favorite language:<br>" +
                "<select name='language3'>" +
                "    <option value='Java'>Java</option>" +
                "    <option value='JavaScript'>JavaScript</option>" +
                "    <option value='Python'>Python</option>" +
                "</select><br>" +
                "<input type = 'submit' value = 'Submit' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String language1, String language2, String language3) {
        String firstFave = null;
        String secondFave = null;
        String thirdFave = null;
        if (language1.contentEquals("Java")) {firstFave = "Java";}
        else if (language1.contentEquals("JavaScript")) {firstFave = "JavaScript";}
        else if (language1.contentEquals("Python")) {firstFave = "Python";}
        if (language2.contentEquals("Java")) {secondFave = "Java";}
        else if (language2.contentEquals("JavaScript")) {secondFave = "JavaScript";}
        else if (language2.contentEquals("Python")) {secondFave = "Python";}
        if (language3.contentEquals("Java")) {thirdFave = "Java";}
        else if (language3.contentEquals("JavaScript")) {thirdFave = "JavaScript";}
        else if (language3.contentEquals("Python")) {thirdFave = "Python";}
        return
//                "<ol>" +
//                "<li>" + firstFave + "</li>" +
//                "<li>" + secondFave + "</li>" +
//                "<li>" + thirdFave + "</li>" +
//                "</ol>";


                "<table style='border:1px solid black;'>" +
                        "<tr>" +
                            "<th>First Favorite" +
                            "<th>Second Favorite" +
                            "<th>Third Favorite" +
                        "</tr>" +
                        "<tr>" +
                            "<th>" + firstFave +
                            "<th>" + secondFave +
                            "<th>" + thirdFave +
                        "</tr>" +
                        "</table>";

    }



}
