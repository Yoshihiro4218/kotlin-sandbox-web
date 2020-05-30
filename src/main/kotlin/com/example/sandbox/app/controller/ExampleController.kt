package com.example.sandbox.app.controller

import com.example.sandbox.data.SampleData.Companion.data
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

    @GetMapping("/excel1")
    fun excel1(model: Model): String {
        model.addAttribute("sampleData1", data["SampleData1"]!!.values)
        return "excel1"
    }
}