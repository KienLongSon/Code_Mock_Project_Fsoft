package service.impl;

import com.microsoft.sqlserver.jdbc.StringUtils;
import dao.ProductDao;
import dto.ProductDto;
import mapper.ProductMapper;
import model.Product;
import service.ProductService;
import util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;
    
    @Override
    public String addProduct(ProductDto productDto) {
        String response = "";
        if (Objects.isNull(productDto)) {
            response = "Không có dữ liệu";
            return response;
        }
        if (StringUtils.isEmpty(productDto.getName())) {
            response = "Tên sản phẩm không được để trống";
            return response;
        }
        if (StringUtils.isEmpty(productDto.getDescription())) {
            response = "Mô tả không được để trống";
            return response;
        }
        try {
            Product product = productDao.getProductByName(productDto.getName());
            if (!Objects.isNull(product)) {
                response = "Tên sản phẩm đã tồn tại";
                return response;
            }
            product = ProductMapper.productDtoToProduct(productDto);
            product.setCreateDate(Utils.getNowTimestamp());
            boolean b = productDao.addProduct(product);
            response = b == true ? "Thêm mới thành công" : "Thêm mới thất bại";
            return response;
        } catch (Exception e) {
            return "Thêm mới thất bại";
        }
    }
    
    @Override
    public List<ProductDto> getAllProduct(Long stock) {
        //truyền constant get trạng thái còn hàng hoặc hết hàng
        try {
            List<Product> products = productDao.getAllProduct();
            List<ProductDto> productDto = new ArrayList<>();
            for (Product product:products) {
                productDto.add(ProductMapper.productToProductDto(product));
            }
            return productDto;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public String updateProduct(ProductDto productDto) {
        String response = "";
        if (Objects.isNull(productDto)) {
            response = "Sản phẩm truyền không tồn tại";
            return response;
        }
        if (StringUtils.isEmpty(productDto.getName())) {
            response = "Tên sản phẩm không được để trống";
            return response;
        }
        if (StringUtils.isEmpty(productDto.getDescription())) {
            response = "Mô tả không được để trống";
            return response;
        }
        try {
            Product product = productDao.getProductById(productDto.getId());
            if (Objects.isNull(product)) {
                response = "Sản phẩm không tồn tại";
                return response;
            }
            if (!Objects.isNull(productDao.getProductByName(productDto.getName())) && !StringUtils.equals(product.getName(),productDto.getName())) {
                response = "Tên sản phẩm đã tồn tại";
                return response;
            }
            product = ProductMapper.updateProduct(product,productDto);
            boolean b = productDao.updateProduct(product);
            response = b == true ? "Cập nhật sản phẩm thành công" : "Cập nhật sản phẩm thất bại";
            return response;
        } catch (Exception e) {
            return "Cập nhật sản phẩm thất bại";
        }
    }
    
    @Override
    public String deleteProductById(int id) {
        String response = "";
        try {
            Product product = productDao.getProductById(id);
            if (Objects.isNull(product)) {
                response = "Sản phẩm không tồn tại";
                return response;
            }
            boolean b = productDao.deleteProductById(id);
            response = b == true ? "Xóa sản phẩm thành công" : "Xóa sản phẩm thất bại";
            return response;
        } catch (Exception e) {
            return "Xóa sản phẩm thất bại";
        }
    }
    
    @Override
    public ProductDto getProductById(int id) {
        try {
            Product product = productDao.getProductById(id);
            if (Objects.isNull(product)) {
                return null;
            }
            return ProductMapper.productToProductDto(product);
        } catch (Exception e) {
            return null;
        }
    }
}
