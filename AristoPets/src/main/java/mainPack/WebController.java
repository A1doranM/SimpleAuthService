package mainPack;
/*
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class WebController {
	
	@Autowired
	@Qualifier("dbservice")
	private DBService dbservice;
	
	@RequestMapping(value = "index/breeder/registration", method = RequestMethod.GET)
	public String getCreate(Model model) {
		  model.addAttribute("Breeder", new Breeder	());
		  return "registration";
	}
	
	@RequestMapping(value = "index/breeder/registration", method = RequestMethod.POST)
	public String create(@ModelAttribute Breeder breeder, Model model) {
		  model.addAttribute("breeder", breeder);
		  dbservice.create(breeder);
		  return "confirmPage";
	}
	
}
*/