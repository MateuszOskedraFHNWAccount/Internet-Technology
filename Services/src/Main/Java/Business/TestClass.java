public AdminActions updateAdminAction(Actiontype ActionType,Int ActionID,AdminActions adminAction) {
        AdminActions existingAction = adminActionsRepository.findById(ActionID).orElse(null);
        if (existingAction != null) {
            existingAction.setType(ActionType);
            AdminActions updatedAction = adminActionsRepository.save(existingAction);
            return adminActionsRepository.ok(updatedAction);
        } else {
            return updatedAction.status(HttpStatus.NOT_FOUND).body(null);
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