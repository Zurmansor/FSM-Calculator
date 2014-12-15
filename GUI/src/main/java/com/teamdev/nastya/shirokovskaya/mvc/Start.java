package com.teamdev.nastya.shirokovskaya.mvc;


import com.teamdev.nastya.shirokovskaya.mvc.controller.Controller;
import com.teamdev.nastya.shirokovskaya.mvc.model.Model;
import com.teamdev.nastya.shirokovskaya.mvc.view.View;

public class Start {
    public static void main(String[] args){
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.control();
    }

}
