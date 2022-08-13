package mapper;

import dto.ProductDto;
import model.Product;

public class ProductMapper {
    static public Product productDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setSold(productDto.getSold());
        product.setStatus(productDto.getStatus());
        product.setStock(productDto.getStock());
        product.setDiscountPrice(productDto.getDiscountPrice());
        return product;
    }
    
    static public ProductDto productToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setSold(product.getSold());
        productDto.setStatus(product.getStatus());
        productDto.setStock(product.getStock());
        productDto.setDiscountPrice(product.getDiscountPrice());
        return productDto;
    }
    
    static public Product updateProduct(Product product, ProductDto productDto) {
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setSold(productDto.getSold());
        product.setStatus(productDto.getStatus());
        product.setStock(productDto.getStock());
        product.setDiscountPrice(productDto.getDiscountPrice());
        return product;
    }
}
