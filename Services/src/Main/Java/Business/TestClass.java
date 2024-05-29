public AccountManagement<?> updateAccountManagement(Long adminId,AccountManagement updatedAccount) {
    try {
        AccountManagement existingAccount = accountManagementRepository.findById(adminId)
        .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + adminId));
        existingAccount.setSomeProperty(updatedAccount.getSomeProperty());
        if(existingAccount = != null){
            if(updatedAccount.)
        }
        AccountManagement savedAccount = accountManagementRepository.save(existingAccount);
        return accountManagementRepository.ok(savedAccount);
    } catch (ResourceNotFoundException e) {
        return savedAccount.notFound().build();
    } catch (Exception e) {
        return savedAccount.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
public Pizza updatePizza(Long id, Pizza pizza) throws Exception {
        Pizza pizzaToUpdate = pizzaRepository.findById(id).get();
        if(pizzaToUpdate != null) {
            if(pizza.getPizzaName() != null)
                pizzaToUpdate.setPizzaName(pizza.getPizzaName());
            if(pizza.getPizzaToppings() != null)
                pizzaToUpdate.setPizzaToppings(pizza.getPizzaToppings());
            return pizzaRepository.save(pizzaToUpdate);
        }
        throw new Exception("Pizza with id " + id + " does not exist");
    }