package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MSM on 05/06/2017.
 */

public class DependentesVO implements Parcelable {
    public static final Creator<DependentesVO> CREATOR = new Creator<DependentesVO>() {
        @Override
        public DependentesVO createFromParcel(Parcel in) {
            return new DependentesVO(in);
        }

        @Override
        public DependentesVO[] newArray(int size) {
            return new DependentesVO[size];
        }
    };
    private int id;
    private int id_pessoa;
    private String nome_dependente;
    private String cpf;
    private String ci;
    private String parentesco;
    private String data_nascimento;
    private String tipo_boletim;
    private String numero_boletim;
    private String data_boletim;
    private String descricao_dependente;

    public DependentesVO() {
    }

    protected DependentesVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        nome_dependente = in.readString();
        cpf = in.readString();
        ci = in.readString();
        parentesco = in.readString();
        data_nascimento = in.readString();
        tipo_boletim = in.readString();
        numero_boletim = in.readString();
        data_boletim = in.readString();
        descricao_dependente = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeString(nome_dependente);
        dest.writeString(cpf);
        dest.writeString(ci);
        dest.writeString(parentesco);
        dest.writeString(data_nascimento);
        dest.writeString(tipo_boletim);
        dest.writeString(numero_boletim);
        dest.writeString(data_boletim);
        dest.writeString(descricao_dependente);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getNome_dependente() {
        return nome_dependente;
    }

    public void setNome_dependente(String nome_dependente) {
        this.nome_dependente = nome_dependente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTipo_boletim() {
        return tipo_boletim;
    }

    public void setTipo_boletim(String tipo_boletim) {
        this.tipo_boletim = tipo_boletim;
    }

    public String getNumero_boletim() {
        return numero_boletim;
    }

    public void setNumero_boletim(String numero_boletim) {
        this.numero_boletim = numero_boletim;
    }

    public String getData_boletim() {
        return data_boletim;
    }

    public void setData_boletim(String data_boletim) {
        this.data_boletim = data_boletim;
    }

    public String getDescricao_dependente() {
        return descricao_dependente;
    }

    public void setDescricao_dependente(String descricao_dependente) {
        this.descricao_dependente = descricao_dependente;
    }


}
