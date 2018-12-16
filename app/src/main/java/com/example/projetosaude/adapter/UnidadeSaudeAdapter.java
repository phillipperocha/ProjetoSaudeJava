//package com.example.projetosaude.adapter;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.List;
//
//import com.example.projetosaude.R;
//import com.example.projetosaude.modelo.UnidadeSaude;
//
///**
// * Created by renan on 12/01/16.
// */
//public class UnidadeSaudeAdapter extends BaseAdapter {
//    private final List<UnidadeSaude> unidadeSaudes;
//    private final Context context;
//
//    public UnidadeSaudeAdapter(Context context, List<UnidadeSaude> unidadeSaudes) {
//        this.context = context;
//        this.unidadeSaudes = unidadeSaudes;
//    }
//
//    @Override
//    public int getCount() {
//        return unidadeSaudes.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return unidadeSaudes.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return unidadeSaudes.get(position).getId();
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        UnidadeSaude unidadeSaude = unidadeSaudes.get(position);
//
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        View view = convertView;
//        if (view == null) {
//            view = inflater.inflate(R.layout.list_item, parent, false);
//        }
//
//        TextView campoNome = (TextView) view.findViewById(R.id.item_nome);
//        campoNome.setText(unidadeSaude.getNome());
//
//        TextView campoTelefone = (TextView) view.findViewById(R.id.item_telefone);
//        campoTelefone.setText(unidadeSaude.getTelefone());
//
//        TextView campoEndereco = (TextView) view.findViewById(R.id.item_endereco);
//        if (campoEndereco != null) {
//            campoEndereco.setText(unidadeSaude.getEndereco());
//        }
//
//        TextView campoSite = (TextView) view.findViewById(R.id.item_site);
//        if (campoSite != null) {
//            campoSite.setText(unidadeSaude.getSite());
//        }
//
//        ImageView campoFoto = (ImageView) view.findViewById(R.id.item_foto);
//        String caminhoFoto = unidadeSaude.getCaminhoFoto();
//        if (caminhoFoto != null) {
//            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
//            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
//            campoFoto.setImageBitmap(bitmapReduzido);
//            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
//        }
//
//        return view;
//    }
//}
