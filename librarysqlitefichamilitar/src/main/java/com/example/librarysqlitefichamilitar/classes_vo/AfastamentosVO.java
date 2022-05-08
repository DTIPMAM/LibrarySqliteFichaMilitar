package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

public class AfastamentosVO implements Parcelable {

    public static final Creator<AfastamentosVO>CREATOR= new Creator<AfastamentosVO>() {

        @Override
        public AfastamentosVO createFromParcel(Parcel in) {
            return new AfastamentosVO(in);
        }

        @Override
        public AfastamentosVO[] newArray(int size) {
            return new AfastamentosVO[size];
        }
    };

    private int id_afastamento;
    private int id_pessoa;
    private String ci;
    private String nome;
    private int status;
    private String data_inicio;
    private String data_termino;
    private String mensagem;


    public AfastamentosVO(Parcel in) {
        id_afastamento = in.readInt();
        id_pessoa = in.readInt();
        ci = in.readString();
        nome = in.readString();
        status = in.readInt();
        data_inicio = in.readString();
        data_termino = in.readString();
        mensagem = in.readString();
    }

    public AfastamentosVO() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_afastamento);
        dest.writeInt(id_pessoa);
        dest.writeString(ci);
        dest.writeString(nome);
        dest.writeInt(status);
        dest.writeString(data_inicio);
        dest.writeString(data_termino);
        dest.writeString(mensagem);
    }

    public int getId_afastamento() {
        return id_afastamento;
    }

    public void setId_afastamento(int id_afastamento) {
        this.id_afastamento = id_afastamento;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_termino() {
        return data_termino;
    }

    public void setData_termino(String data_termino) {
        this.data_termino = data_termino;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
