package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MSM on 05/06/2017.
 */

public class CursosMilitaresVO implements Parcelable {
    private int id;
    private int id_pessoa;
    private String tipoCursoMilitar;
    private String nome_curso;
    private String instituicaoEnsino;
    private String inicio;
    private String finl;
    private String carga_horaria;

    public CursosMilitaresVO() {
    }

    protected CursosMilitaresVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        tipoCursoMilitar = in.readString();
        nome_curso = in.readString();
        instituicaoEnsino = in.readString();
        inicio = in.readString();
        finl = in.readString();
        carga_horaria = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeString(tipoCursoMilitar);
        dest.writeString(nome_curso);
        dest.writeString(instituicaoEnsino);
        dest.writeString(inicio);
        dest.writeString(finl);
        dest.writeString(carga_horaria);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CursosMilitaresVO> CREATOR = new Creator<CursosMilitaresVO>() {
        @Override
        public CursosMilitaresVO createFromParcel(Parcel in) {
            return new CursosMilitaresVO(in);
        }

        @Override
        public CursosMilitaresVO[] newArray(int size) {
            return new CursosMilitaresVO[size];
        }
    };

    public String getTipoCursoMilitar() {
        return tipoCursoMilitar;
    }

    public void setTipoCursoMilitar(String tipoCursoMilitar) {
        this.tipoCursoMilitar = tipoCursoMilitar;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    public void setInstituicaoEnsino(String instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public String getFinl() {
        return finl;
    }

    public void setFinl(String finl) {
        this.finl = finl;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
