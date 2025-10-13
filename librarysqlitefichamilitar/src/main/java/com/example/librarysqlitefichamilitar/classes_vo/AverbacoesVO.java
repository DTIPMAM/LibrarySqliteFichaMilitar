package com.example.librarysqlitefichamilitar.classes_vo;


import android.os.Parcel;
import android.os.Parcelable;

public class AverbacoesVO implements Parcelable {

    private int _id;
    private int idPessoa;
    private String local;
    private String tipo;
    private int numero_dias;
    private String boletim;

    public AverbacoesVO() {
    }

    protected AverbacoesVO(Parcel in) {
        _id = in.readInt();
        idPessoa = in.readInt();
        local = in.readString();
        tipo = in.readString();
        numero_dias = in.readInt();
        boletim = in.readString();
    }

    public static final Creator<AverbacoesVO> CREATOR = new Creator<AverbacoesVO>() {
        @Override
        public AverbacoesVO createFromParcel(Parcel in) {
            return new AverbacoesVO(in);
        }

        @Override
        public AverbacoesVO[] newArray(int size) {
            return new AverbacoesVO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "AverbacoesVO{" +
                "_id=" + _id +
                ", idPessoa=" + idPessoa +
                ", local='" + local + '\'' +
                ", tipo='" + tipo + '\'' +
                ", numero_dias=" + numero_dias +
                ", boletim='" + boletim + '\'' +
                '}';
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero_dias() {
        return numero_dias;
    }

    public void setNumero_dias(int numero_dias) {
        this.numero_dias = numero_dias;
    }

    public String getBoletim() {
        return boletim;
    }

    public void setBoletim(String boletim) {
        this.boletim = boletim;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeInt(idPessoa);
        dest.writeString(local);
        dest.writeString(tipo);
        dest.writeInt(numero_dias);
        dest.writeString(boletim);
    }
}

