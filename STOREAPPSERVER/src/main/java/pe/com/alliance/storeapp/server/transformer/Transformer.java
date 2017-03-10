package pe.com.alliance.storeapp.server.transformer;

import java.util.List;

public interface Transformer <Model, Entidad> {

	public Model transformToModel(Entidad entidad);
	public Entidad transformToEntidad(Model model);
	public List<Model> transformToModel(List<Entidad> entidades);
	public List<Entidad> transformToEntidad(List<Model> models);
}
