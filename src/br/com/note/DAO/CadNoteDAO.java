/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.note.DAO;

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import br.com.note.entidade.Note;
import java.util.List;

/**
 *
 * @author f82cpd01
 */
public class CadNoteDAO extends AbstractConecxaoDAO {
   
	public boolean inserir(Note note) {
		try {
                        
			objectContainer.store(note);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeDB();
		}
	}


	public Note buscar(Note Note) {

		try {
			ObjectSet<Note> funcion = objectContainer
					.queryByExample(Note);
			if (funcion.size() < 1) {
				return null;
			} else {
				return funcion.get(0);
			}
		} finally {
                       //closeDB();
		}
		}
        public List<Note> buscaPorNome(String func) {
                    final String t = func;
			List<Note> result=objectContainer.query(new Predicate<Note>() {

                            @Override
                            public boolean match(Note func) {
                                
                            
				return func.getDescricao().startsWith(t);
                            }
                        });
		
                                return result;
                   
		}
       
        public List<Note> buscaPorMat(String func) {
                    final String t = func;
			List<Note> result=objectContainer.query(new Predicate<Note>() {

                            @Override
                            public boolean match(Note func) {
                                
                            
				return func.getDescricao().startsWith(t);
                            }
                        });
		
                                return result;
                   
		}
        
        public List<Note> BuscaTodos() {

		try {
			List<Note> funci = objectContainer
					.queryByExample(Note.class);
			if (funci.size() < 1) {
				return null;
			} else {
				return funci;
			}
		} finally {
                        // closeDB();
		}
		}

	
	public boolean alterar(Note note) {
		return inserir(note);
	}


	public boolean delete(Note note) {
		try {
			objectContainer.delete(note);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeDB();
		}
	}
        
        
       public List<?> mostraUltimoCad() {
           try {
		ObjectSet result = objectContainer.queryByExample(Note.class);
           if (result.size() < 1) {
		return null;
			}else{
               return  result;
               
           }
           }finally {
               
			//closeDB();
		}
       }
}
