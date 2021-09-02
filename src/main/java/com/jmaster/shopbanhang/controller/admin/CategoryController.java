 package com.jmaster.shopbanhang.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jmaster.shopbanhang.entity.CategoryEntity;
import com.jmaster.shopbanhang.model.CategoryDTO;
import com.jmaster.shopbanhang.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("categoryDTO", new CategoryDTO());
		return "admin/categories/addOrEdit";
	}
	
	@GetMapping("edit/{categoryId}")
	public ModelAndView edit(ModelMap modelMap, @PathVariable(name = "categoryId")Long id) {
		
		Optional<CategoryEntity> optional = categoryService.findById(id);
		
		CategoryDTO categoryDTO = new CategoryDTO();
		
		if(optional.isPresent()) {
			CategoryEntity categoryEntity = optional.get();
			BeanUtils.copyProperties(categoryEntity, categoryDTO);
			categoryDTO.setEdit(true);
			
			modelMap.addAttribute("categoryDTO", categoryDTO);
			
			return new ModelAndView("admin/categories/addOrEdit",modelMap);
		}else {
			modelMap.addAttribute("msg", "Sản phẩm không tồn tại");
			return new ModelAndView("forward:/admin/categories",modelMap);
		}
	}
	
	@GetMapping("delete/{categoryId}")
	public ModelAndView delete( ModelMap modelMap,
			@PathVariable(name = "categoryId") Long id) {
		
		categoryService.deleteById(id);
		
		modelMap.addAttribute("msg", "Đã xóa sản phẩm!");
		
		return new ModelAndView("forward:/admin/categories/search",modelMap);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, CategoryDTO categoryDTO) {
		
		CategoryEntity categoryEntity = new CategoryEntity();
		
		BeanUtils.copyProperties(categoryDTO, categoryEntity);//copy tat ca thuoc tinh cua DTO -> Entity
	
		categoryService.save(categoryEntity);
		
		model.addAttribute("msg", "Sản Phẩm Đã Được Thêm!");
		
		return new ModelAndView("forward:/admin/categories",model); //forward : chuyển hưởng ở phía server..chuyển request cho list
	}
	
	@RequestMapping("") // su dung forward thi chuyen tu GET -> RequestMapping
	public String list(ModelMap model) {
		List<CategoryEntity> list = categoryService.findAll();
		
		model.addAttribute("categories", list);
		
		return "admin/categories/search";
	}
	
	@GetMapping("search")
	public String seach(ModelMap modelMap, @RequestParam(name = "name", required = false)String name) {
		
		List<CategoryEntity> list = null;
		
		if(StringUtils.hasText(name)) { // hastext : kiem tra xem co noi dung hay khong
			list = categoryService.findByName(name);
		}else {
			list =  categoryService.findAll();
		}
		
		modelMap.addAttribute("categories", list);
		
		return "admin/categories/search";
	}
	
	@GetMapping("/searchPage")
	public String seach(ModelMap modelMap, 
			@RequestParam(name = "name", required = false)String name,
			@RequestParam(name = "page") Optional<Integer> page,
			@RequestParam(name = "size") Optional<Integer> size) {
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("name"));
		
		Page<CategoryEntity> resultPage = null;
		
		
		if(StringUtils.hasText(name)) { // hastext : kiem tra xem co noi dung hay khong
			resultPage = categoryService.findByName(name,pageable);
			modelMap.addAttribute("name", name);
		}else {
			resultPage =  categoryService.findAll(pageable);
		}
		
		int totalPages = resultPage.getTotalPages();
		
		if(totalPages > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage +2, totalPages);
			if(totalPages > 5) {
				if (end == totalPages) {
					start = end - 5;
				}else if(start == 1) {
					end = start + 5;
				}
			}
				List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
						.boxed()
						.collect(Collectors.toList());
				modelMap.addAttribute("pageNumbers", pageNumbers);
			}
			
		
		modelMap.addAttribute("categoryPage", resultPage);
		
		return "admin/categories/searchPage";
	}
}
