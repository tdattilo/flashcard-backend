package lingflashbackend;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.json.*;
import java.util.Date;
import java.util.Optional;
//import java.io.InputStream;

import lingflashbackend.People;
import lingflashbackend.PeopleRepository;
import lingflashbackend.Book;
import lingflashbackend.BookRepository;
import lingflashbackend.Chapter;
import lingflashbackend.ChapterRepository;
import lingflashbackend.Word;
import lingflashbackend.WordRepository;


@RestController
@RequestMapping(path="/pm")
public class MainController {

	@Autowired
	private PeopleRepository peopleRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ChapterRepository chapterRepository;
	@Autowired
	private WordRepository wordRepository;

	@GetMapping(path="/test")
	public @ResponseBody String testCall(){
		return "Success!";
	}
	@PostMapping(path="/testunpw")
	public @ResponseBody String login(@RequestBody String data){
		String username1 = "dattilo";
		String password1 = "fingerscrossed";
		if(username1.equals("dattilo")){
			if(password1.equals("fingerscrossed")){
				return "{\"response\":\"1\"}";
			}
		}
		return "{\"response\":\"Unsuccessful Attempt.\"}";
	}


/*	@GetMapping(path="/userinfo/get")
	public @ResponseBody Optional<Userinfo> getUserinfo(@RequestParam Integer uid) {
		return userinfoRepository.findById(uid);
	
	}
	
	@PostMapping(path="/upw/login")
	public @ResponseBody String login(@RequestParam String un,
			String pw) {
		Upw u = new Upw();
		u = upwRepository.findByUnAndPw(un,pw);
		if(u != null){
			SecurityTest s = new SecurityTest();
			return s.encrypt(u.getId());
		}
		return "-1";
	}

	@GetMapping(path="/project/add")
	public @ResponseBody String addNewProject (@RequestParam String projectname,
			int createuser, String description) {
			if(upwRepository.existsById(createuser)){
				if(projectname.length()<40){
					if(description.length()<280){
						Project n = new Project();
						n.setProjectname(projectname);
						n.setCreateuser(createuser);
						projectRepository.save(n);
						return "Successful";
					}
			}
		}
		return "Unsuccessful";
	}

	@GetMapping(path="/project/delete")
	public @ResponseBody String deleteProject (@RequestParam Integer id) {
		if(projectRepository.existsById(id)){
			projectRepository.deleteById(id);
			return "Successful";
			}
		return "Unsuccessful";
	}

	@GetMapping(path="/project/update")	
	public @ResponseBody String updateProject (@RequestParam Integer id, String projectname,
		Integer createuser, String description) {
		if(upwRepository.existsById(createuser)){
			if(projectRepository.existsById(id)){
				if(projectname.length()<40){
					if(description.length()<280){
						Project n = new Project();
						n.setId(id);
						n.setProjectname(projectname);
						n.setCreateuser(createuser);
						projectRepository.save(n);	
						return "Successful";
					}
				}
			}
		}
		return "Unsuccessful";
	}
	@GetMapping(path="project/find")
	public @ResponseBody Optional<Project> findProject(@RequestParam Integer id){
		return projectRepository.findById(id);
	}
	@PostMapping(path="project/findp")
	public @ResponseBody Optional<Project> findProjectP(@RequestParam Integer id){
		return projectRepository.findById(id);
	}
	
	@GetMapping(path="/project/all")
	public @ResponseBody Iterable<Project> getAllProjects() {
		return projectRepository.findAll();
	
	}
	
	@GetMapping(path="/completionlevel/add")
	public @ResponseBody String addNewCompletionLevel (@RequestParam String levelname,
			Integer levelorder, Integer projectID) {
		if(projectRepository.existsById(projectID)){
			if(levelname.length()<40){
				Completionlevel n = new Completionlevel();
				n.setLevelname(levelname);
				n.setLevelorder(levelorder);
				n.setLevelcomplete(false);
				n.setProjectid(projectID);
				completionlevelRepository.save(n);
				return "Successful";
			}
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/completionlevel/delete")
	public @ResponseBody String deleteCompletionLevel (@RequestParam Integer id) {
		if (completionlevelRepository.existsById(id)){
			completionlevelRepository.deleteById(id);
			return "Successful";
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/completionlevel/update")
	public @ResponseBody String updateCompletionLevel (@RequestParam Integer id, String levelname,
			Integer levelorder, Boolean levelcomplete, Integer projectID) {
		if(completionlevelRepository.existsById(id)){
			if(projectRepository.existsById(projectID)){
				if(levelname.length()<40){
					if(levelorder>0){
						if(levelcomplete==true || levelcomplete==false){
							Completionlevel n = new Completionlevel();
							n.setId(id);
							n.setLevelname(levelname);
							n.setLevelorder(levelorder);
							n.setLevelcomplete(levelcomplete);
							n.setProjectid(projectID);
							completionlevelRepository.save(n);
							return "Successful";
						}
					}
				}
			}
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/completionlevel/all")
	public @ResponseBody Iterable<Completionlevel> getAllCompletionlevels() {
		return completionlevelRepository.findAll();
	
	}
	@GetMapping(path="/element/add")
	public @ResponseBody String addNewElement (@RequestParam String elementname,
			Integer elementorder, String description, Integer projectID) {
		if(projectRepository.existsById(projectID)){
			if(elementname.length()<40){
				if (elementorder>0){
					if(description.length()<280){
						Element n = new Element();
						n.setElementname(elementname);
						n.setElementorder(elementorder);
						n.setDescription(description);
						n.setProjectid(projectID);
						elementRepository.save(n);
						return "Successful";
					}
				}
			}
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/element/delete")
	public @ResponseBody String deleteElement (@RequestParam Integer id) {
		if (elementRepository.existsById(id)){
			elementRepository.deleteById(id);
			return "Successful";
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/element/update")
	public @ResponseBody String updateElement (@RequestParam Integer id, String elementname,
			Integer elementorder, String description, Integer projectID) {
		if(elementRepository.existsById(id)){
			if(projectRepository.existsById(projectID)){
				if(elementname.length()<40){
					if(elementorder>0){
						if(description.length()<280){
							Element n = new Element();
							n.setId(id);
							n.setElementname(elementname);
							n.setElementorder(elementorder);
							n.setDescription(description);
							n.setProjectid(projectID);
							elementRepository.save(n);
							return "Successful";
						}
					}
				}
			}
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/element/all")
	public @ResponseBody Iterable<Element> getAllElement() {
		return elementRepository.findAll();
	
	}
	@GetMapping(path="/requirement/add")
	public @ResponseBody String addNewRequirement (@RequestParam String requirementname,
			Integer requirementorder, String description, Integer projectID) {
		if(projectRepository.existsById(projectID)){
			if(requirementname.length()<40){
				if(requirementorder>0){
					if(description.length()<280){
						Requirement n = new Requirement();
						n.setRequirementname(requirementname);
						n.setRequirementorder(requirementorder);
						n.setDescription(description);
						n.setProjectid(projectID);
						requirementRepository.save(n);
						return "Successful";
					}
				}
			}
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/requirement/delete")
	public @ResponseBody String deleteRequirement (@RequestParam Integer id) {
		if (requirementRepository.existsById(id)){
			requirementRepository.deleteById(id);
			return "Successful";
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/requirement/update")
	public @ResponseBody String updateRequirement (@RequestParam Integer id, String requirementname,
			Integer requirementorder, String description, Integer projectID) {
		if(requirementRepository.existsById(id)){
			if(projectRepository.existsById(projectID)){
				if(requirementname.length()<40){
					if(requirementorder>0){
						if(description.length()<280){
							Requirement n = new Requirement();
							n.setId(id);
							n.setRequirementname(requirementname);
							n.setRequirementorder(requirementorder);
							n.setDescription(description);
							n.setProjectid(projectID);
							requirementRepository.save(n);
							return "Successful";
						}
					}
				}
			}
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/requirement/all")
	public @ResponseBody Iterable<Requirement> getAllRequirements() {
		return requirementRepository.findAll();
	
	}
	
	@GetMapping(path="/task/add")
	public @ResponseBody String addNewTask (@RequestParam String taskname,
			Integer taskorder, String notes, Integer userassignment, Date duedate,
			Integer level) {
		Task n = new Task();
		Date date = new Date();
		if(completionlevelRepository.existsById(level)){
			if(taskname.length()<40){
				if(taskorder>0){
					if(userinfoRepository.existsById(userassignment)){
						if(duedate.getTime()>date.getTime()){
							n.setTaskname(taskname);
							n.setTaskorder(taskorder);
							n.setNotes(notes);
							n.setUserassignment(userassignment);
							n.setDuedate(duedate);
							n.setComplete(false);
							n.setLevel(level);
							taskRepository.save(n);
							return "Successful";
						}
					}
				}
			}
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/task/delete")
	public @ResponseBody String deleteTask (@RequestParam Integer id) {
		if(taskRepository.existsById(id)){
			taskRepository.deleteById(id);
			return "Successful";
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/task/update")
	public @ResponseBody String updateTask (@RequestParam Integer id, String taskname,
			Integer taskorder, String notes, Integer userassignment, Date duedate,
			Boolean complete, Integer level) {
		Task n = new Task();
		Date date = new Date();
		if(taskRepository.existsById(id)){
			if(completionlevelRepository.existsById(level)){
				if(taskname.length()<40){
					if(taskorder>0){
						if(userinfoRepository.existsById(userassignment)){
							if(duedate.getTime()>date.getTime()){
								if(complete==true||complete==false){
									n.setId(id);
									n.setTaskname(taskname);
									n.setTaskorder(taskorder);
									n.setNotes(notes);
									n.setUserassignment(userassignment);
									n.setDuedate(duedate);
									n.setComplete(complete);
									n.setLevel(level);
									taskRepository.save(n);
									return "Successful";
								}
							}
						}
					}
				}
			}
		}
		return "Unsuccessful";
	}
	
	@GetMapping(path="/task/all")
	public @ResponseBody Iterable<Task> getAllTasks() {
		return taskRepository.findAll();
	
	}*/
}