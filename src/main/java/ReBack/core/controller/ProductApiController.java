package ReBack.core.controller;

import ReBack.core.data.Product;
import ReBack.core.repository.CategoryRepository;
import ReBack.core.repository.MaterialRepository;
import ReBack.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductApiController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MaterialRepository materialRepository;


    @PutMapping("/update")
    public void productUpdate(@RequestBody Product product) {
        System.out.println("수정api");
        System.out.println(product.getProductFilePath() + " 사진경로") ;
        Optional<Product> searchProduct = productRepository.findById(product.getProductCode());

        if (searchProduct.isPresent()) {
            product.setProductFilePath(searchProduct.get().getProductFilePath());
            product.setProductFileName(searchProduct.get().getProductFileName());
        }
        productRepository.save(product);

    }

    @DeleteMapping("/delete")
    public void productDelete(@RequestBody Product product) {
        Optional<Product> deleteProduct = productRepository.findById(product.getProductCode());

        if (deleteProduct.isPresent()) {
            System.out.println(deleteProduct);
            productRepository.delete(product);
        }

    }

    @PostMapping("/add")
    public void productAdd(@Validated @RequestPart(value = "key") Product product,
                                     @RequestPart(value = "file") MultipartFile file,
                                     HttpServletRequest request) throws Exception {
        String fileName;
        if (file == null) {
            fileName = "";
        } else {
            fileName = file.getOriginalFilename(); //
            String filepath = request.getSession().getServletContext().getRealPath("") + "file\\" ; // webapps/file
            System.out.println("filepath  :    " + filepath);
            try {

            file.transferTo(new File(filepath+fileName));
            System.out.println("업로드 성공");
            product.setProductFileName(fileName);
            product.setProductFilePath("/file/" + fileName);

            } catch (IllegalStateException | IOException e) {
            System.out.println("실패");
            e.printStackTrace();
        }
        }

        productRepository.save(product);
//        return new ResponseEntity<>(HttpStatus.OK);
    }
}
//System.out.println(file + "file");
//        System.out.println(request);
//        System.out.println(product);
//        String path =  request.getSession().getServletContext().getRealPath("") + + "\\src\\main\\resources\\static\\file";
//        System.out.println(path);
//
//        String fileName = file.getOriginalFilename();
//
//        System.out.println(fileName);
//
//
//        File saveFile = new File(path, fileName);
//
//        file.transferTo(saveFile);
//
//        product.setProductFileName(fileName);
//        product.setProductFilePath("file/" + fileName);
//
//        System.out.println(product);

//String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\file" ;