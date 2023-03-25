package pro.sky.simplecalculator;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalcController {
    private final CalcService service;

    public CalcController(CalcService service) {
        this.service = service;
    }

    @GetMapping()
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) int num1,
                       @RequestParam(value = "num2", required = false) int num2) {
        return num1 + " + " + num2 + " = " + service.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) int num1,
                        @RequestParam(value = "num2", required = false) int num2) {
        return num1 + " - " + num2 + " = " + service.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) int num1,
                           @RequestParam(value = "num2", required = false) int num2) {
        return num1 + " * " + num2 + " = " + service.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) int num1,
                         @RequestParam(value = "num2", required = false) int num2) {
        if (num2 != 0) {
            return num1 + " / " + num2 + " = " + service.divide(num1, num2);
        } else return "Ошибка - на ноль делить нельзя!";
    }
}
