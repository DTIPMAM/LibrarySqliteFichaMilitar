package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MSM on 05/06/2017.
 */

public class PromocoesVO implements Parcelable {
    private int id;
    private int id_pessoa;
    private String TipoPromocao;
    private String descricao_promocao;
    private String data_boletim;

    public PromocoesVO() {
    }

    protected PromocoesVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        TipoPromocao = in.readString();
        descricao_promocao = in.readString();
        data_boletim = in.readString();
        numero_boletim = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeString(TipoPromocao);
        dest.writeString(descricao_promocao);
        dest.writeString(data_boletim);
        dest.writeString(numero_boletim);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PromocoesVO> CREATOR = new Creator<PromocoesVO>() {
        @Override
        public PromocoesVO createFromParcel(Parcel in) {
            return new PromocoesVO(in);
        }

        @Override
        public PromocoesVO[] newArray(int size) {
            return new PromocoesVO[size];
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

    public String getTipoPromocao() {
        return TipoPromocao;
    }

    public void setTipoPromocao(String tipoPromocao) {
        TipoPromocao = tipoPromocao;
    }

    public String getDescricao_promocao() {
        return descricao_promocao;
    }

    public void setDescricao_promocao(String descricao_promocao) {
        this.descricao_promocao = descricao_promocao;
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

    private String numero_boletim;


}
