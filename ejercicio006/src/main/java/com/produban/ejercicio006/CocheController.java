package com.produban.ejercicio006;

import java.util.List;

public interface CocheController {
	public Coche create(Coche coche);
	public List<Coche> list();
	public Coche get(Long id);
	public Coche update(Coche coche);
	public void delete(Long id);	
}
