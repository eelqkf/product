package ReBack.core.controller;

import ReBack.core.data.Product;
import ReBack.core.repository.CategoryRepository;
import ReBack.core.repository.MaterialRepository;
import ReBack.core.repository.ProductRepository;
import ReBack.core.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@org.springframework.stereotype.Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MaterialRepository materialRepository;
    @Autowired
    ProductService productService;


    @GetMapping("/product") //상품 조회 페이지 [모든사람]
    public String ProductPage(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam (required = false, defaultValue = "0", value = "page")  int page) {

        System.out.println("RequestParam으로받은 page" +page);
        page = 100;
        Page<Product> listPage = productService.list(page);

        int totalPage = 7;// 총 페이지수
        System.out.println("토탈 페이지" + totalPage);
        model.addAttribute("productlists",listPage.getContent());
        model.addAttribute("totalPage",totalPage);

//        List<Product> productList = (List<Product>) productRepository.findAll(pageable);
        model.addAttribute("products", productRepository.findAll(pageable));
        model.addAttribute("categorys", categoryRepository.findAll(pageable));
        return "productPage";
    }

    @GetMapping("/product/manager") //상품 조회 페이지 [모든사람]
    public String productManager(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam (required = false, defaultValue = "0", value = "page")  int page) {

        System.out.println("RequestParam으로받은 page" +page);
        page = 100;
        Page<Product> listPage = productService.list(page);

        int totalPage = 7;// 총 페이지수
        System.out.println("토탈 페이지" + totalPage);
        model.addAttribute("productlists",listPage.getContent());
        model.addAttribute("totalPage",totalPage);

//        List<Product> productList = (List<Product>) productRepository.findAll(pageable);
        model.addAttribute("products", productRepository.findAll(pageable));
        model.addAttribute("categorys", categoryRepository.findAll(pageable));
        return "productManager";
    }



    @GetMapping("/product/manage") //상품 관리 페이지 [수정 및 삭제]
    public String productManage(Model model, @RequestParam(required = false) Long id) {


        System.out.println("받은id = "+id);
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("categoryCode", product.getCategoryCode());
        model.addAttribute("productName", product.getProductName());
        model.addAttribute("productCode", product.getProductCode());
        model.addAttribute("productInfo", product.getProductInfo());
        model.addAttribute("productPrice", product.getProductPrice());
        model.addAttribute("productStock", product.getProductStock());
        model.addAttribute("materialCode", product.getMaterialCode());
        model.addAttribute("productFileName", product.getProductFileName());
        model.addAttribute("productFilePath", product.getProductFilePath());
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("materials", materialRepository.findAll());

        return "productManage";
    }

    @GetMapping("/product/add") //상품 등록 페이지
    public String productAdd(Model model){
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("materials", materialRepository.findAll());
        return "productAdd";
    }

    @GetMapping("/product/details")
    public String productDetails(Model model, @RequestParam(required = false) Long id){

        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("categoryCode", product.getCategoryCode());
        model.addAttribute("categoryName", product.getCategoryCode().getCategoryName());
        model.addAttribute("materialCode", product.getMaterialCode());
        model.addAttribute("materialName", product.getMaterialCode().getMaterialName());
        model.addAttribute("productName", product.getProductName());
        model.addAttribute("productCode", product.getProductCode());
        model.addAttribute("productInfo", product.getProductInfo());
        model.addAttribute("productPrice", product.getProductPrice());
        model.addAttribute("productStock", product.getProductStock());

        model.addAttribute("productFileName", product.getProductFileName());
        model.addAttribute("productFilePath", product.getProductFilePath());
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("materials", materialRepository.findAll());

        return "productDetails";
    }

    //    @GetMapping("") //상품 조회 페이지 [관리자]
//    public String AdminProductPage(Model model , @PageableDefault(size = 5) Pageable pageable, @RequestParam (required = false, defaultValue = "0", value = "page")  int page) {
//        System.out.println("RequestParam으로받은 page"+page);
//        page = 100;
//        Page<Product> listPage = productService.list(page);
//
//        int totalPage = 7;// 총 페이지수
//        System.out.println("토탈 페이지" + totalPage);
//        model.addAttribute("productlists",listPage.getContent());
//        model.addAttribute("totalPage",totalPage);
//
//        model.addAttribute("products", productRepository.findAll(pageable));
//        model.addAttribute("categorys", categoryRepository.findAll(pageable));
//        return "productManager";
//    }
}
