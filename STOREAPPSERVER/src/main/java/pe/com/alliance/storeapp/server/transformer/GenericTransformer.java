package pe.com.alliance.storeapp.server.transformer;

import java.util.ArrayList;
import java.util.List;

public class GenericTransformer<Model, Entidad> implements Transformer<Model, Entidad>{

	@Override
	public Model transformToModel(Entidad entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidad transformToEntidad(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Model> transformToModel(List<Entidad> entidades) {
		List<Model> models = new ArrayList<Model>();
		for (Entidad entidad : entidades) {
			models.add(transformToModel(entidad));
		}
		return models;
	}

	@Override
	public List<Entidad> transformToEntidad(List<Model> models) {
		List<Entidad> entidades = new ArrayList<Entidad>();
		for (Model model : models) {
			entidades.add(transformToEntidad(model));
		}
		return entidades;
	}

}
