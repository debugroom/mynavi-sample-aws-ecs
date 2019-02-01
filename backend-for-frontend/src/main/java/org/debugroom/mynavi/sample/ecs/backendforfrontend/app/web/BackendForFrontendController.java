package org.debugroom.mynavi.sample.ecs.backendforfrontend.app.web;

import org.debugroom.mynavi.sample.ecs.backendforfrontend.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestOperations;

import javax.annotation.PostConstruct;

@Controller
public class BackendForFrontendController {

    @Autowired
    RestOperations restOperations;

    @RequestMapping(method = RequestMethod.GET, value = "users")
    public String getUsers(Model model){
        String service = "/backend/api/v1/users";
        model.addAttribute("users",
                restOperations.getForObject(service, User[].class));
        return "users";
    }

}
