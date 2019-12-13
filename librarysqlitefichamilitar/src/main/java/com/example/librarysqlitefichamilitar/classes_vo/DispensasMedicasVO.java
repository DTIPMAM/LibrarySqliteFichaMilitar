package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MSM on 05/06/2017.
 */

public class DispensasMedicasVO implements Parcelable {
    public static final Creator<DispensasMedicasVO> CREATOR = new Creator<DispensasMedicasVO>() {
        @Override
        public DispensasMedicasVO createFromParcel(Parcel in) {
            return new DispensasMedicasVO(in);
        }

        @Override
        public DispensasMedicasVO[] newArray(int size) {
            return new DispensasMedicasVO[size];
        }
    };
    private int id;
    private int id_pessoa;
    private String data_inicio;
    private String data_termino;
    private String data_boletim;
    private String tipo_boletim;
    private String numero_boletim;
    private String cid;

    public DispensasMedicasVO() {
    }

    protected DispensasMedicasVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        data_inicio = in.readString();
        data_termino = in.readString();
        data_boletim = in.readString();
        tipo_boletim = in.readString();
        numero_boletim = in.readString();
        cid = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeString(data_inicio);
        dest.writeString(data_termino);
        dest.writeString(data_boletim);
        dest.writeString(tipo_boletim);
        dest.writeString(numero_boletim);
        dest.writeString(cid);
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

    public String getData_boletim() {
        return data_boletim;
    }

    public void setData_boletim(String data_boletim) {
        this.data_boletim = data_boletim;
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

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
