package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MSM on 05/06/2017.
 */

public class FormacaoAcademicaVO implements Parcelable {
    private int id;
    private int id_pessoa;
    private String area;
    private String nome_curso;
    private String instituicao;
    private String finl;
    private String carga_horaria;
    private String completo;

    public FormacaoAcademicaVO() {
    }

    protected FormacaoAcademicaVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        area = in.readString();
        nome_curso = in.readString();
        instituicao = in.readString();
        finl = in.readString();
        carga_horaria = in.readString();
        completo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeString(area);
        dest.writeString(nome_curso);
        dest.writeString(instituicao);
        dest.writeString(finl);
        dest.writeString(carga_horaria);
        dest.writeString(completo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FormacaoAcademicaVO> CREATOR = new Creator<FormacaoAcademicaVO>() {
        @Override
        public FormacaoAcademicaVO createFromParcel(Parcel in) {
            return new FormacaoAcademicaVO(in);
        }

        @Override
        public FormacaoAcademicaVO[] newArray(int size) {
            return new FormacaoAcademicaVO[size];
        }
    };

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getFinl() {
        return finl;
    }

    public void setFinl(String finl) {
        this.finl = finl;
    }

    public String getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public String getCompleto() {
        return completo;
    }

    public void setCompleto(String completo) {
        this.completo = completo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
