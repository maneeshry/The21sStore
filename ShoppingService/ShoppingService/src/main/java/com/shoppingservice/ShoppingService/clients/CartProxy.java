package com.shoppingservice.ShoppingService.clients;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.shoppingservice.ShoppingService.model.CompositeCart;

@FeignClient(name = "cart-service", url = "localhost:8005")
public interface CartProxy {

    @RequestMapping(method = RequestMethod.POST, value = "/cart/add")
    public void addCompositeCart(@RequestBody CompositeCart cartItem);

  @GetMapping("/cart/{customerId}")
  public CompositeCart getCompositeCart(@PathVariable("customerId") int cartId); 

  @GetMapping("/cart/items")
  public List<CompositeCart> getAllItems();   

  @PostMapping("/cart/add")
  public void insert(@RequestBody CompositeCart cart);  

  @DeleteMapping("/cart/{customerId}")
  public void deleteCartItem(@PathVariable("customerId") int customerId);

  @GetMapping("customer/{customerId}/cart")
  public List<CompositeCart> getCustomerItems(@PathVariable("customerId") int customerId);
}
