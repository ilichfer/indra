package com.api.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.exceptions.MessageException;
import com.api.service.IDias;

@Service
public class DiasService implements IDias {

	List<Integer> barrio;
	Integer anterior;
	Integer siguiente;
	List<Integer> barrioTemp;;

	@Override
	public String calcular(Integer dias, List<Integer> list) {

		validar(list);
		barrioTemp = constriur(dias, list);

		return convert(barrioTemp);
	}

	public void validar(List<Integer> barrio) {
		if (barrio.size() != 8 || barrio.isEmpty()) {
			throw new MessageException(400);
		}

		if (!barrio.isEmpty()) {
			for (Integer integer : barrio) {
				if (integer < 0 || integer > 1) {
					throw new MessageException(401);
				}
			}

		}

	}

	public String convert(List<Integer> barrio) {

		StringBuilder sb = new StringBuilder();

		for (Integer integer : barrio) {
			sb.append("|" + integer);
		}

		return sb.toString();
	}

	public List<Integer> constriur(Integer dias, List<Integer> barrio) {

		for (int i = 0; i < dias; i++) {
			barrioTemp = new ArrayList<Integer>();
			for (int j = 0; j < barrio.size(); j++) {

				if (j == 0) {
					anterior = 0;
					siguiente = barrio.get(j + 1);
					if (anterior != siguiente) {
						Integer actual = 1;
						barrioTemp.add(actual);
					} else {
						Integer actual = 0;
						barrioTemp.add(actual);
					}
				}
				if (j > 0 && j < (barrio.size() - 1)) {
					anterior = barrio.get(j - 1);
					siguiente = barrio.get(j + 1);

					if (anterior != siguiente) {
						Integer actual = 1;
						barrioTemp.add(actual);
					} else {
						Integer actual = 0;
						barrioTemp.add(actual);
					}

				}
				if (j == (barrio.size() - 1)) {
					anterior = barrio.get(j - 1);
					siguiente = 0;

					if (!anterior.equals(siguiente)) {
						Integer actual = 1;
						barrioTemp.add(actual);
					} else {
						Integer actual = 0;
						barrioTemp.add(actual);
					}

				}

			}
			barrio = barrioTemp;
		}
		return barrioTemp;

	}

}
