public void deletePizza(Long id) throws Exception {
        if(pizzaRepository.existsById(id)) {
            pizzaRepository.deleteById(id);
        } else
            throw new Exception("Pizza with id " + id + " does not exist");
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


public Pizza addPizza(Pizza pizza) throws Exception {
        if(pizza.getPizzaName() != null) {
            if (pizzaRepository.findByPizzaName(pizza.getPizzaName()) == null)
                return pizzaRepository.save(pizza);
            throw new Exception("Pizza " + pizza.getPizzaName() + " already exists");
        }
        throw new Exception("Invalid pizza name ");
    }

public List<Pizza> getAllPizzas() {
        List<Pizza> pizzaList = pizzaRepository.findAll();
        return pizzaList;
    }