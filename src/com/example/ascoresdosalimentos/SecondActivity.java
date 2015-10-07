package com.example.ascoresdosalimentos;

//import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

//import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

	GridView gv;
	LinearLayout ll;

	ArrayList<Food> mList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		gv = (GridView) findViewById(R.id.gvMainActivity);
		ll = (LinearLayout) findViewById(R.id.llMainActivity);
		mList = getFoodList();
		addViews();
	}

	OnClickListener mOnClick = new View.OnClickListener() {

		@Override
		public void onClick(final View v) {
			Food f = (Food) v.getTag();
			if (f.getState()) {
				f.setState(false);
				v.setTag(f);
			} else if (gv.getChildCount() >= 9) {
				Toast.makeText(SecondActivity.this, "O MAXIMO DE 9 PRATOS",
						Toast.LENGTH_LONG).show();
				return;
			} else {

				f.setState(true);
				v.setTag(f);
			}
			ll.removeAllViews();
			addViews();
		}
	};

	void addViews() {
		ArrayList<Food> alF = new ArrayList<Food>();
		for (Food f : mList) {
			if (f.getState()) {
				alF.add(f);
			} else {
				ll.addView(getFoodView(f));

			}
		}
		MyAdapter m = new MyAdapter(alF, this);
		gv.setAdapter(m);

	}

	public ArrayList<Food> getFoodList() {
		ArrayList<Food> al = new ArrayList<Food>();
		al.add(new Food(R.drawable.beans, "Feijão"));
		al.add(new Food(R.drawable.alface, "Alface"));
		//al.add(new Food(R.drawable.apple, "Maçã"));
		al.add(new Food(R.drawable.batata, "Batata"));
		al.add(new Food(R.drawable.pizzas, "Pizza"));
		al.add(new Food(R.drawable.beef, "Carne"));
		al.add(new Food(R.drawable.steak, "Carne"));
		al.add(new Food(R.drawable.bolo, "Bolo"));
		al.add(new Food(R.drawable.bread, "Pão"));
		//al.add(new Food(R.drawable.breads, "Pãos"));
		al.add(new Food(R.drawable.brocolis, "Brocolis"));
		//al.add(new Food(R.drawable.cakes, "Bolos"));
		//al.add(new Food(R.drawable.candy, "Doce"));
		al.add(new Food(R.drawable.cenoura, "Cenoura"));
		al.add(new Food(R.drawable.cheese, "Queijo"));
		//al.add(new Food(R.drawable.cheese1, "Queijo1"));
		//al.add(new Food(R.drawable.frango, "Frango"));
		al.add(new Food(R.drawable.chocolate, "Chocolate"));
		//al.add(new Food(R.drawable.corn, "Milho"));
		al.add(new Food(R.drawable.rice, "Paos"));
		al.add(new Food(R.drawable.egg, "Ovo"));
		al.add(new Food(R.drawable.fish, "Peixe"));
		al.add(new Food(R.drawable.frango, "Frango"));
		al.add(new Food(R.drawable.peanuts, "Amendoin"));
		al.add(new Food(R.drawable.melancia,"Melancia"));
		al.add(new Food(R.drawable.morango, "Morango"));
		al.add(new Food(R.drawable.sorvete, "Sorvete"));
		al.add(new Food(R.drawable.spaghetti, "Macarrão"));
		al.add(new Food(R.drawable.sweet, "Doce"));
		al.add(new Food(R.drawable.sweetcorn, "Milho"));
		al.add(new Food(R.drawable.tomato, "Tomate"));
		return al;
	}

	public View getFoodView(Food f) {
		View v = LayoutInflater.from(this).inflate(R.layout.adapter_food, null);
		((ImageView) v.findViewById(R.id.ivFoodAdapter)).setImageResource(f
				.getResource());
		((TextView) v.findViewById(R.id.tvFoodAdapter)).setText(f.getName());
		v.setTag(f);
		v.setOnClickListener(mOnClick);
		return v;
	}

	class MyAdapter extends BaseAdapter {

		ArrayList<Food> al;
		Context c;

		public MyAdapter(ArrayList<Food> al, Context c) {
			super();
			this.al = al;
			this.c = c;
		}

		@Override
		public int getCount() {
			return al.size();
		}

		@Override
		public Object getItem(int position) {
			return al.get(position);
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Food f = al.get(position);
			View v = LayoutInflater.from(c)
					.inflate(R.layout.adapter_food, null);
			((ImageView) v.findViewById(R.id.ivFoodAdapter)).setImageResource(f
					.getResource());
			((TextView) v.findViewById(R.id.tvFoodAdapter))
					.setText(f.getName());
			v.setTag(f);
			v.setOnClickListener(mOnClick);
			return v;
		}

	}

}
