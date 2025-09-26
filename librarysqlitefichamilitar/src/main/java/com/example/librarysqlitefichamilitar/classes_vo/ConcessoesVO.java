package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ConcessoesVO implements Parcelable {
    private int id;
    private String inicio;
    private String termino;
    private int numero_dias;
    private String tipo_concessoes;

    protected ConcessoesVO(Parcel in) {
        id = in.readInt();
        inicio = in.readString();
        termino = in.readString();
        numero_dias = in.readInt();
        tipo_concessoes = in.readString();
        id_pessoa = in.readInt();
        tipo_boletim_inicio = in.readString();
        data_boletim_inicio = in.readString();
        numero_boletim_inicio = in.readInt();
    }

    public static final Creator<ConcessoesVO> CREATOR = new Creator<ConcessoesVO>() {
        @Override
        public ConcessoesVO createFromParcel(Parcel in) {
            return new ConcessoesVO(in);
        }

        @Override
        public ConcessoesVO[] newArray(int size) {
            return new ConcessoesVO[size];
        }
    };

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }


    @Override
    public String toString() {
        return "ConcessoesVO{" +
                "id=" + id +
                ", inicio='" + inicio + '\'' +
                ", termino='" + termino + '\'' +
                ", numero_dias=" + numero_dias +
                ", tipo_concessoes='" + tipo_concessoes + '\'' +
                ", id_pessoa=" + id_pessoa +
                ", tipo_boletim_inicio='" + tipo_boletim_inicio + '\'' +
                ", data_boletim_inicio='" + data_boletim_inicio + '\'' +
                ", numero_boletim_inicio=" + numero_boletim_inicio +
                '}';
    }

    private int id_pessoa;

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public ConcessoesVO() {
    }

    public int getNumero_dias() {
        return numero_dias;
    }

    public void setNumero_dias(int numero_dias) {
        this.numero_dias = numero_dias;
    }

    public String getTipo_concessoes() {
        return tipo_concessoes;
    }

    public void setTipo_concessoes(String tipo_concessoes) {
        this.tipo_concessoes = tipo_concessoes;
    }

    public String getTipo_boletim_inicio() {
        return tipo_boletim_inicio;
    }

    public void setTipo_boletim_inicio(String tipo_boletim_inicio) {
        this.tipo_boletim_inicio = tipo_boletim_inicio;
    }

    public String getData_boletim_inicio() {
        return data_boletim_inicio;
    }

    public void setData_boletim_inicio(String data_boletim_inicio) {
        this.data_boletim_inicio = data_boletim_inicio;
    }

    public int getNumero_boletim_inicio() {
        return numero_boletim_inicio;
    }

    public void setNumero_boletim_inicio(int numero_boletim_inicio) {
        this.numero_boletim_inicio = numero_boletim_inicio;
    }

    private String tipo_boletim_inicio;
    private String data_boletim_inicio;
    private int numero_boletim_inicio;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(inicio);
        dest.writeString(termino);
        dest.writeInt(numero_dias);
        dest.writeString(tipo_concessoes);
        dest.writeInt(id_pessoa);
        dest.writeString(tipo_boletim_inicio);
        dest.writeString(data_boletim_inicio);
        dest.writeInt(numero_boletim_inicio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }
}
