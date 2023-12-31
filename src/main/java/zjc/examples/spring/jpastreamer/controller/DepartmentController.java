package zjc.examples.spring.jpastreamer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zjc.examples.spring.jpastreamer.dto.DepartmentDTO;
import zjc.examples.spring.jpastreamer.dto.EmployeeDTO;
import zjc.examples.spring.jpastreamer.repository.DepartmentRepository;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository repository;

    public DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/title/{name}")
    public String findByTitle(@PathVariable("name") String name) {
        return repository.findByTitle(name);
    }

    @GetMapping
    public List<DepartmentDTO> listAll() {
        return repository.listAll();
    }

    @GetMapping("/{id}/count-employees")
    public long getNumberOfEmployees(@PathVariable("id") Integer id) {
        return repository.getNumberOfEmployees(id);
    }

    @GetMapping("/{id}/employees")
    public List<EmployeeDTO> getEmployees(@PathVariable("id") Integer id) {
        return repository.getEmployees(id);
    }
}
