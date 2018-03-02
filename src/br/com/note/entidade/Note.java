/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.note.entidade;

/**
 *
 * @author f82cpd01
 */
public class Note {
    private String descricao;
    private boolean arquivado;

    public Note() {
        super();
    }

    public Note(String descricao, boolean arquivado) {
        this.descricao = descricao;
        this.arquivado = arquivado;
    }

    public boolean isArquivado() {
        return arquivado;
    }

    public void setArquivado(boolean arquivado) {
        this.arquivado = arquivado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

  
}
