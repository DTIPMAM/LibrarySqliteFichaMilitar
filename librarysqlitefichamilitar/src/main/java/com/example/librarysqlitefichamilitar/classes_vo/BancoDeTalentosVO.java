package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

public class BancoDeTalentosVO implements Parcelable {

    private int id;
    private int id_pessoa;
    private int id_tipo_curso_academico;
    private int id_banco_talentos;
    private int id_instituicao_ensino;
    private int carga_horaria;
    private String nome_curso;
    private String inicio_data;
    private String final_data;
    private String completo;
    private String modalidade;

    public BancoDeTalentosVO() {
    }

    protected BancoDeTalentosVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        id_tipo_curso_academico = in.readInt();
        id_banco_talentos = in.readInt();
        id_instituicao_ensino = in.readInt();
        carga_horaria = in.readInt();
        nome_curso = in.readString();
        inicio_data = in.readString();
        final_data = in.readString();
        completo = in.readString();
        modalidade = in.readString();
    }

    @Override
    public String toString() {
        return "BancoDeTalentosVO{" +
                "id=" + id +
                ", id_pessoa=" + id_pessoa +
                ", id_tipo_curso_academico=" + id_tipo_curso_academico +
                ", id_banco_talentos=" + id_banco_talentos +
                ", id_instituicao_ensino=" + id_instituicao_ensino +
                ", carga_horaria=" + carga_horaria +
                ", nome_curso='" + nome_curso + '\'' +
                ", inicio_data='" + inicio_data + '\'' +
                ", final_data='" + final_data + '\'' +
                ", completo='" + completo + '\'' +
                ", modalidade='" + modalidade + '\'' +
                '}';
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeInt(id_tipo_curso_academico);
        dest.writeInt(id_banco_talentos);
        dest.writeInt(id_instituicao_ensino);
        dest.writeInt(carga_horaria);
        dest.writeString(nome_curso);
        dest.writeString(inicio_data);
        dest.writeString(final_data);
        dest.writeString(completo);
        dest.writeString(modalidade);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getId_tipo_curso_academico() {
        return id_tipo_curso_academico;
    }

    public void setId_tipo_curso_academico(int id_tipo_curso_academico) {
        this.id_tipo_curso_academico = id_tipo_curso_academico;
    }

    public int getId_banco_talentos() {
        return id_banco_talentos;
    }

    public void setId_banco_talentos(int id_banco_talentos) {
        this.id_banco_talentos = id_banco_talentos;
    }

    public int getId_instituicao_ensino() {
        return id_instituicao_ensino;
    }

    public void setId_instituicao_ensino(int id_instituicao_ensino) {
        this.id_instituicao_ensino = id_instituicao_ensino;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getInicio_data() {
        return inicio_data;
    }

    public void setInicio_data(String inicio_data) {
        this.inicio_data = inicio_data;
    }

    public String getFinal_data() {
        return final_data;
    }

    public void setFinal_data(String final_data) {
        this.final_data = final_data;
    }

    public String getCompleto() {
        return completo;
    }

    public void setCompleto(String completo) {
        this.completo = completo;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BancoDeTalentosVO> CREATOR = new Creator<BancoDeTalentosVO>() {
        @Override
        public BancoDeTalentosVO createFromParcel(Parcel in) {
            return new BancoDeTalentosVO(in);
        }

        @Override
        public BancoDeTalentosVO[] newArray(int size) {
            return new BancoDeTalentosVO[size];
        }
    };
}
