package br.com.avaliacao.assembleia.votacao.domain.Util;

import java.util.UUID;

public class UuidProvider {

  public static String get() {
    return UUID.randomUUID().toString();
  }
}