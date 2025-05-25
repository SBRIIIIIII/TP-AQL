


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Order;
import org.example.OrderController;
import org.example.OrderDao;
import org.example.OrderService;
import org.junit.jupiter.api.Test;

class OrderControllerTest {

    @Test
    void testCreateOrder() {
        // Arrange
        OrderDao orderDaoMock = mock(OrderDao.class);
        OrderService orderService = new OrderService(orderDaoMock);
        OrderController orderController = new OrderController(orderService);

        Order order = new Order(1L, "New laptop");

        // Act
        orderController.createOrder(order);

        // Assert
        verify(orderDaoMock).saveOrder(order); // Vérifie que saveOrder est appelé
    }
}

