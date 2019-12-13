package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MSM on 05/06/2017.
 */

public class ElogiosVO implements Parcelable {

    private int id;
    private int id_pessoa;
    private String data_elogio;
    private String descricao_elogio;
    private String nome_autoridade;
    private String data_boletim;
    private String numero_boletim;

    public ElogiosVO() {
    }

    protected ElogiosVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        data_elogio = in.readString();
        descricao_elogio = in.readString();
        nome_autoridade = in.readString();
        data_boletim = in.readString();
        numero_boletim = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeString(data_elogio);
        dest.writeString(descricao_elogio);
        dest.writeString(nome_autoridade);
        dest.writeString(data_boletim);
        dest.writeString(numero_boletim);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ElogiosVO> CREATOR = new Creator<ElogiosVO>() {
        @Override
        public ElogiosVO createFromParcel(Parcel in) {
            return new ElogiosVO(in);
        }

        @Override
        public ElogiosVO[] newArray(int size) {
            return new ElogiosVO[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_elogio() {
        return data_elogio;
    }

    public void setData_elogio(String data_elogio) {
        this.data_elogio = data_elogio;
    }

    public String getDescricao_elogio() {
        return descricao_elogio;
    }

    public void setDescricao_elogio(String descricao_elogio) {
        this.descricao_elogio = descricao_elogio;
    }

    public String getNome_autoridade() {
        return nome_autoridade;
    }

    public void setNome_autoridade(String nome_autoridade) {
        this.nome_autoridade = nome_autoridade;
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

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
}
