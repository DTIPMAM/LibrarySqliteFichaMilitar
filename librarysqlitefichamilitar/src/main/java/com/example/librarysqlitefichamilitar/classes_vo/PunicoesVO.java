package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MSM on 05/06/2017.
 */

public class PunicoesVO implements Parcelable {
    private int id;
    private int id_pessoa;
    private String data_punicao;
    private String descricao_punicao;
    private String data_boletim;
    private String numero_boletim;

    protected PunicoesVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        data_punicao = in.readString();
        descricao_punicao = in.readString();
        data_boletim = in.readString();
        numero_boletim = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeString(data_punicao);
        dest.writeString(descricao_punicao);
        dest.writeString(data_boletim);
        dest.writeString(numero_boletim);
    }

    public PunicoesVO() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PunicoesVO> CREATOR = new Creator<PunicoesVO>() {
        @Override
        public PunicoesVO createFromParcel(Parcel in) {
            return new PunicoesVO(in);
        }

        @Override
        public PunicoesVO[] newArray(int size) {
            return new PunicoesVO[size];
        }
    };

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

    public String getData_punicao() {
        return data_punicao;
    }

    public void setData_punicao(String data_punicao) {
        this.data_punicao = data_punicao;
    }

    public String getDescricao_punicao() {
        return descricao_punicao;
    }

    public void setDescricao_punicao(String descricao_punicao) {
        this.descricao_punicao = descricao_punicao;
    }

    public String getData_boletim() {
        return data_boletim;
    }

    public void setData_boletim(String data_boletim) {
        this.data_boletim = data_boletim;
    }

    public String getNumero_boletim() {
        return numero_boletim;
    }

    public void setNumero_boletim(String numero_boletim) {
        this.numero_boletim = numero_boletim;
    }


}
