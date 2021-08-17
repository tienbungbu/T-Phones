 package com.jmaster.shopbanhang.controller.admin;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jmaster.shopbanhang.entity.CategoryEntity;
import com.jmaster.shopbanhang.entity.ProductEntity;
import com.jmaster.shopbanhang.model.CategoryDTO;
import com.jmaster.shopbanhang.model.ProductDTO;
import com.jmaster.shopbanhang.service.CategoryService;
import com.jmaster.shopbanhang.service.ProductService;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	/////////////// LẤY THÔNG TIN CATEGORIES///////////////////
	@ModelAttribute("categories") 
	public List<CategoryDTO> getCategories(){
		return categoryService.findAll().stream().map(item ->{
			CategoryDTO categoryDTO = new CategoryDTO();
			BeanUtils.copyProperties(item, categoryDTO);
			return categoryDTO;		
		}).toList();
	}///////////////////////////////////////////////////////////
	
	@GetMapping("add")
	public String add(Model model) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setIsEdit(false);
		model.addAttribute("productDTO", productDTO);

		return "admin/products/addOrEdit";
	}
	
//	@PostMapping("add") //UPLOAD FILE
//	public String uploadImageProduct(@RequestParam(name = "imageProduct")MultipartFile file) {
//		System.out.println(file.getOriginalFilename());
//		return "redirect:/admin/products";
//	}
	
	@GetMapping("edit/{productId}")
	public ModelAndView edit(ModelMap modelMap, @PathVariable(name = "productId")Long productId) {
		
		Optional<ProductEntity> optional = productService.findById(productId);
		
		ProductDTO productDTO = new ProductDTO();
		
		if(optional.isPresent()) {
			ProductEntity productEntity = optional.get();
			BeanUtils.copyProperties(productEntity, productDTO);
			productDTO.setCategoryId(productEntity.getCategoryEntity().getCategoryId());
			
			productDTO.setIsEdit(true);
			
			modelMap.addAttribute("productDTO", productDTO);
			
			return new ModelAndView("admin/products/addOrEdit",modelMap);
		}else {
			modelMap.addAttribute("msg", "Sản phẩm không tồn tại");
			return new ModelAndView("forward:/admin/products",modelMap);
		}
	}
	
	@GetMapping("delete/{productId}")
	public ModelAndView delete( ModelMap modelMap,
			@PathVariable(name = "productId") Long productId) {
		
		
		 Optional<ProductEntity> optional = productService.findById(productId);
		 
		 productService.delete(optional.get());
		 
		
		modelMap.addAttribute("msg", "Đã xóa sản phẩm!");
		
		return new ModelAndView("forward:/admin/products/",modelMap);
	}
	
	//////////// LƯU MỚI HOẶC CẬP NHẬT PRODUCT/////////////////
	@PostMapping("/saveOrEdit")
	public ModelAndView saveOrUpdate(ModelMap model, 
			 @ModelAttribute(name = "productDTO") ProductDTO productDTO, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("admin/products/addOrEdit");
		}
		
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(productDTO, productEntity);//copy tat ca thuoc tinh cua DTO -> Entity
		
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryId(productDTO.getCategoryId());
		productEntity.setCategoryEntity(categoryEntity);
		
	
		productService.save(productEntity);
		
		model.addAttribute("msg", "Sản Phẩm Đã Được Thêm!");
		
		return new ModelAndView("forward:/admin/products",model); //forward : chuyển hưởng ở phía server..chuyển request cho list
	}
	
	/////////////////////////////////////////////////////////////
	
	
	
	@RequestMapping("") // su dung forward thi chuyen tu GET -> RequestMapping
	public String list(ModelMap model) {
		List<ProductEntity> list = productService.findAll();
		
		model.addAttribute("products", list);
		
		return "admin/products/search";
	}
	
	@GetMapping("search")
	public String seach(ModelMap modelMap, @RequestParam(name = "name", required = false)String name) {
		
		List<CategoryEntity> list = null;
		
		if(StringUtils.hasText(name)) { // hastext : kiem tra xem co noi dung hay khong
			list = categoryService.findByName(name);
		}else {
			list =  categoryService.findAll();
		}
		
		modelMap.addAttribute("products", list);
		
		return "admin/products/search";
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
		
		List<CategoryEntity> list = null;
		
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
		
		return "admin/products/searchPage";
	}
	
	
}
