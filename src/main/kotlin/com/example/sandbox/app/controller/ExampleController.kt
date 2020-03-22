package com.example.sandbox.app.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/example")
class ExampleController {

    @GetMapping("")
    fun hello(@RequestParam(value = "name", required = false, defaultValue = "ゲスト") name: String,
              model: Model): String {
        model.addAttribute("name", name)
        return "example"
    }
}