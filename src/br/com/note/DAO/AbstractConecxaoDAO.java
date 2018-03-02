

package br.com.note.DAO;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public abstract class AbstractConecxaoDAO {

	private static final String DB4O = "controle.db4o";

	ObjectContainer objectContainer;

	public AbstractConecxaoDAO() {
		objectContainer = Db4oEmbedded.openFile(
				Db4oEmbedded.newConfiguration(), DB4O);
            }
	

	public void closeDB() {
		objectContainer.close();
	}

}
