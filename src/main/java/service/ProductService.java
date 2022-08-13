package service;

import dto.ProductDto;

import java.util.List;

public interface ProductService {
    String addProduct(ProductDto productDto);
    List<ProductDto> getAllProduct(Long stock);
    String updateProduct(ProductDto productDto);
    String deleteProductById(int id);
    ProductDto getProductById(int id);
}
