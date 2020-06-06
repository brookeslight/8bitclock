package main;

import java.awt.Color;
import java.awt.Graphics;

public class Clock {
	private final byte[] CHAR_EXCLAMATION = {1, 3, 1, 4, 2, 3, 2, 4, 3, 3, 3, 4, 4, 3, 4, 4, 6, 3, 6, 4};
	private final byte[] CHAR_DOUBLEQUOTE = {1, 1, 1, 2, 1, 5, 1, 6, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6};
	private final byte[] CHAR_HASHTAG = {1, 1, 1, 2, 1, 5, 1, 6, 2, 0, 2, 1, 2, 2, 2, 3, 2, 4, 2, 5, 2, 6, 2, 7, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 0, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 5, 7, 6, 1, 6, 2, 6, 5, 6, 6};
	private final byte[] CHAR_DOLLARSIGN = {0, 3, 0, 4, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 2, 1, 2, 2, 3, 2, 3, 3, 3, 4, 3, 5, 4, 5, 4, 6, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 6, 3, 6, 4};
	private final byte[] CHAR_PERCENT = {1, 1, 1, 2, 1, 5, 1, 6, 2, 1, 2, 2, 2, 4, 2, 5, 3, 3, 3, 4, 4, 2, 4, 3, 5, 1, 5, 2, 5, 5, 5, 6, 6, 1, 6, 5, 6, 6};
	private final byte[] CHAR_AND = {0, 3, 0, 4, 0, 5, 1, 2, 1, 3, 1, 5, 1, 6, 2, 3, 2, 4, 2, 5, 3, 2, 3, 3, 3, 4, 4, 1, 4, 2, 4, 4, 4, 5, 4, 6, 4, 7, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 6, 6, 7};
	private final byte[] CHAR_SINGLEQUOTE = {1, 3, 1, 4, 2, 3, 2, 4, 3, 3, 3, 4};
	private final byte[] CHAR_OPENBRACE = {1, 4, 1, 5, 1, 6, 2, 3, 2, 4, 2, 5, 3, 3, 3, 4, 4, 3, 4, 4, 5, 3, 5, 4, 5, 5, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_CLOSEBRACE = {1, 1, 1, 2, 1, 3, 2, 2, 2, 3, 2, 4, 3, 3, 3, 4, 4, 3, 4, 4, 5, 2, 5, 3, 5, 4, 6, 1, 6, 2, 6, 3};
	private final byte[] CHAR_STAR = {1, 1, 1, 2, 1, 5, 1, 6, 2, 2, 2, 3, 2, 4, 2, 5, 3, 0, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 3, 7, 4, 2, 4, 3, 4, 4, 4, 5, 5, 1, 5, 2, 5, 5, 5, 6};
	private final byte[] CHAR_PLUS = {1, 3, 1, 4, 2, 3, 2, 4, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 4, 3, 4, 4, 5, 3, 5, 4};
	private final byte[] CHAR_COMMA = {5, 3, 5, 4, 6, 3, 6, 4, 7, 2, 7, 3};
	private final byte[] CHAR_DASH = {3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6};
	private final byte[] CHAR_PERIOD = {5, 3, 5, 4, 6, 3, 6, 4};
	private final byte[] CHAR_FORWARDSLASH = {1, 5, 1, 6, 2, 4, 2, 5, 3, 3, 3, 4, 4, 2, 4, 3, 5, 1, 5, 2, 6, 1};
	private final byte[] CHAR_0 = {1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 4, 3, 5, 3, 6, 4, 1, 4, 2, 4, 3, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_1 = {1, 3, 1, 4, 2, 2, 2, 3, 2, 4, 3, 3, 3, 4, 4, 3, 4, 4, 5, 3, 5, 4, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_2 = {1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 4, 3, 5, 4, 3, 4, 4, 5, 2, 5, 3, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_3 = {1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 2, 4, 2, 5, 3, 3, 3, 4, 4, 4, 4, 5, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_4 = {1, 4, 1, 5, 2, 3, 2, 4, 2, 5, 3, 2, 3, 3, 3, 4, 3, 5, 4, 1, 4, 2, 4, 4, 4, 5, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 6, 4, 6, 5};
	private final byte[] CHAR_5 = {1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 2, 1, 2, 2, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_6 = {1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_7 = {1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 2, 5, 2, 6, 3, 4, 3, 5, 4, 3, 4, 4, 5, 2, 5, 3, 6, 2, 6, 3};
	private final byte[] CHAR_8 = {1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 2, 3, 3, 3, 4, 3, 5, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_9 = {1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 4, 5, 4, 6, 5, 4, 5, 5, 6, 2, 6, 3, 6, 4};
	private final byte[] CHAR_COLON = {2, 3, 2, 4, 3, 3, 3, 4, 5, 3, 5, 4, 6, 3, 6, 4};
	private final byte[] CHAR_SEMICOLON = {2, 3, 2, 4, 3, 3, 3, 4, 5, 3, 5, 4, 6, 3, 6, 4, 7, 2, 7, 3};
	private final byte[] CHAR_OPENARROW = {0, 5, 0, 6, 1, 4, 1, 5, 2, 3, 2, 4, 3, 2, 3, 3, 4, 3, 4, 4, 5, 4, 5, 5, 6, 5, 6, 6};
	private final byte[] CHAR_EQUALS = {2, 1, 2, 2, 2, 3, 2, 4, 2, 5, 2, 6, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6};
	private final byte[] CHAR_CLOSEARROW = {0, 1, 0, 2, 1, 2, 1, 3, 2, 3, 2, 4, 3, 4, 3, 5, 4, 3, 4, 4, 5, 2, 5, 3, 6, 1, 6, 2};
	private final byte[] CHAR_QUESTIONMARK = {1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 4, 3, 5, 4, 3, 4, 4, 6, 3, 6, 4};
	private final byte[] CHAR_AT = {1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 4, 3, 5, 3, 6, 4, 1, 4, 2, 4, 4, 4, 5, 4, 6, 5, 1, 5, 2, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_A = {1, 3, 1, 4, 2, 2, 2, 3, 2, 4, 2, 5, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 6, 1, 6, 2, 6, 5, 6, 6};
	private final byte[] CHAR_B = {1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_C = {1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 4, 1, 4, 2, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_D = {1, 1, 1, 2, 1, 3, 1, 4, 2, 1, 2, 2, 2, 4, 2, 5, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 4, 5, 5, 6, 1, 6, 2, 6, 3, 6, 4};
	private final byte[] CHAR_E = {1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 2, 1, 2, 2, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 4, 1, 4, 2, 5, 1, 5, 2, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_F = {1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 2, 1, 2, 2, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 4, 1, 4, 2, 5, 1, 5, 2, 6, 1, 6, 2};
	private final byte[] CHAR_G = {1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 2, 1, 2, 2, 3, 1, 3, 2, 4, 1, 4, 2, 4, 4, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_H = {1, 1, 1, 2, 1, 5, 1, 6, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 1, 6, 2, 6, 5, 6, 6};
	private final byte[] CHAR_I = {1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 2, 3, 2, 4, 3, 3, 3, 4, 4, 3, 4, 4, 5, 3, 5, 4, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_J = {1, 4, 1, 5, 1, 6, 2, 5, 2, 6, 3, 5, 3, 6, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_K = {1, 1, 1, 2, 1, 5, 1, 6, 2, 1, 2, 2, 2, 4, 2, 5, 3, 1, 3, 2, 3, 3, 3, 4, 4, 1, 4, 2, 4, 3, 4, 4, 5, 1, 5, 2, 5, 4, 5, 5, 6, 1, 6, 2, 6, 5, 6, 6};
	private final byte[] CHAR_L = {1, 1, 1, 2, 2, 1, 2, 2, 3, 1, 3, 2, 4, 1, 4, 2, 5, 1, 5, 2, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_M = {1, 1, 1, 2, 1, 6, 1, 7, 2, 1, 2, 2, 2, 3, 2, 5, 2, 6, 2, 7, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 3, 7, 4, 1, 4, 2, 4, 4, 4, 6, 4, 7, 5, 1, 5, 2, 5, 6, 5, 7, 6, 1, 6, 2, 6, 6, 6, 7};
	private final byte[] CHAR_N = {1, 1, 1, 2, 1, 5, 1, 6, 2, 1, 2, 2, 2, 3, 2, 5, 2, 6, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 4, 1, 4, 2, 4, 3, 4, 4, 4, 5, 4, 6, 5, 1, 5, 2, 5, 4, 5, 5, 5, 6, 6, 1, 6, 2, 6, 5, 6, 6};
	private final byte[] CHAR_O = {1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_P = {1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 3, 4, 4, 4, 5, 5, 1, 5, 2, 6, 1, 6, 2};
	private final byte[] CHAR_Q = {1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 4, 5, 5, 6, 2, 6, 3, 6, 5, 6, 6};
	private final byte[] CHAR_R = {1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 3, 4, 4, 4, 5, 5, 1, 5, 2, 5, 4, 5, 5, 6, 1, 6, 2, 6, 5, 6, 6};
	private final byte[] CHAR_S = {1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 2, 2, 3, 2, 3, 3, 3, 4, 3, 5, 4, 5, 4, 6, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_T = {1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 2, 3, 2, 4, 3, 3, 3, 4, 4, 3, 4, 4, 5, 3, 5, 4, 6, 3, 6, 4};
	private final byte[] CHAR_U = {1, 1, 1, 2, 1, 5, 1, 6, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_V = {1, 1, 1, 2, 1, 5, 1, 6, 2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 2, 5, 3, 5, 4, 5, 5, 6, 3, 6, 4};
	private final byte[] CHAR_W = {1, 1, 1, 2, 1, 6, 1, 7, 2, 1, 2, 2, 2, 6, 2, 7, 3, 1, 3, 2, 3, 4, 3, 6, 3, 7, 4, 1, 4, 2, 4, 3, 4, 4, 4, 5, 4, 6, 4, 7, 5, 1, 5, 2, 5, 3, 5, 5, 5, 6, 5, 7, 6, 1, 6, 2, 6, 6, 6, 7};
	private final byte[] CHAR_X = {1, 1, 1, 2, 1, 5, 1, 6, 2, 1, 2, 2, 2, 5, 2, 6, 3, 2, 3, 3, 3, 4, 3, 5, 4, 2, 4, 3, 4, 4, 4, 5, 5, 1, 5, 2, 5, 5, 5, 6, 6, 1, 6, 2, 6, 5, 6, 6};
	private final byte[] CHAR_Y = {1, 1, 1, 2, 1, 5, 1, 6, 2, 1, 2, 2, 2, 5, 2, 6, 3, 2, 3, 3, 3, 4, 3, 5, 4, 3, 4, 4, 5, 3, 5, 4, 6, 3, 6, 4};
	private final byte[] CHAR_Z = {1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 2, 4, 2, 5, 3, 3, 3, 4, 4, 2, 4, 3, 5, 1, 5, 2, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_OPENSQUAREBRACE = {1, 3, 1, 4, 1, 5, 1, 6, 2, 3, 2, 4, 3, 3, 3, 4, 4, 3, 4, 4, 5, 3, 5, 4, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_BACKSLASH = {1, 1, 2, 1, 2, 2, 3, 2, 3, 3, 4, 3, 4, 4, 5, 4, 5, 5, 6, 5, 6, 6};
	private final byte[] CHAR_CLOSESQUAREBRACE = {1, 1, 1, 2, 1, 3, 1, 4, 2, 3, 2, 4, 3, 3, 3, 4, 4, 3, 4, 4, 5, 3, 5, 4, 6, 1, 6, 2, 6, 3, 6, 4};
	private final byte[] CHAR_POWER = {1, 4, 2, 3, 2, 4, 2, 5, 3, 2, 3, 3, 3, 5, 3, 6, 4, 1, 4, 2, 4, 6, 4, 7};
	private final byte[] CHAR_UNDERSCORE = {6, 0, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6, 6, 7};
	private final byte[] CHAR_a = {2, 2, 2, 3, 2, 4, 2, 5, 3, 5, 3, 6, 4, 2, 4, 3, 4, 4, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_b = {1, 1, 1, 2, 2, 1, 2, 2, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_c = {2, 2, 2, 3, 2, 4, 2, 5, 3, 1, 3, 2, 4, 1, 4, 2, 5, 1, 5, 2, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_d = {1, 5, 1, 6, 2, 5, 2, 6, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_e = {2, 2, 2, 3, 2, 4, 2, 5, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 3, 4, 4, 4, 5, 4, 6, 5, 1, 5, 2, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_f = {1, 4, 1, 5, 1, 6, 2, 3, 2, 4, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 4, 3, 4, 4, 5, 3, 5, 4, 6, 3, 6, 4};
	private final byte[] CHAR_g = {2, 2, 2, 3, 2, 4, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 6, 5, 6, 6, 7, 1, 7, 2, 7, 3, 7, 4, 7, 5};
	private final byte[] CHAR_h = {1, 1, 1, 2, 2, 1, 2, 2, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 1, 6, 2, 6, 5, 6, 6};
	private final byte[] CHAR_i = {1, 3, 1, 4, 3, 2, 3, 3, 3, 4, 4, 3, 4, 4, 5, 3, 5, 4, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_j = {1, 5, 1, 6, 3, 5, 3, 6, 4, 5, 4, 6, 5, 5, 5, 6, 6, 5, 6, 6, 7, 2, 7, 3, 7, 4, 7, 5};
	private final byte[] CHAR_k = {1, 1, 1, 2, 2, 1, 2, 2, 3, 1, 3, 2, 3, 4, 3, 5, 4, 1, 4, 2, 4, 3, 4, 4, 5, 1, 5, 2, 5, 4, 5, 5, 6, 1, 6, 2, 6, 5, 6, 6};
	private final byte[] CHAR_l = {1, 2, 1, 3, 1, 4, 2, 3, 2, 4, 3, 3, 3, 4, 4, 3, 4, 4, 5, 3, 5, 4, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_m = {2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 3, 6, 3, 7, 4, 1, 4, 2, 4, 3, 4, 4, 4, 5, 4, 6, 4, 7, 5, 1, 5, 2, 5, 4, 5, 6, 5, 7, 6, 1, 6, 2, 6, 6, 6, 7};
	private final byte[] CHAR_n = {2, 1, 2, 2, 2, 3, 2, 4, 2, 5, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 1, 6, 2, 6, 5, 6, 6};
	private final byte[] CHAR_o = {2, 2, 2, 3, 2, 4, 2, 5, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_p = {2, 1, 2, 2, 2, 3, 2, 4, 2, 5, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 3, 5, 4, 5, 5, 6, 1, 6, 2, 7, 1, 7, 2};
	private final byte[] CHAR_q = {2, 2, 2, 3, 2, 4, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 6, 5, 6, 6, 7, 5, 7, 6};
	private final byte[] CHAR_r = {2, 1, 2, 2, 2, 3, 2, 4, 2, 5, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 5, 1, 5, 2, 6, 1, 6, 2};
	private final byte[] CHAR_s = {2, 2, 2, 3, 2, 4, 2, 5, 2, 6, 3, 1, 3, 2, 4, 2, 4, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5};
	private final byte[] CHAR_t = {1, 3, 1, 4, 2, 1, 2, 2, 2, 3, 2, 4, 2, 5, 2, 6, 3, 3, 3, 4, 4, 3, 4, 4, 5, 3, 5, 4, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_u = {2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 1, 5, 2, 5, 5, 5, 6, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_v = {2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 2, 5, 3, 5, 4, 5, 5, 6, 3, 6, 4};
	private final byte[] CHAR_w = {2, 1, 2, 2, 2, 6, 2, 7, 3, 1, 3, 2, 3, 4, 3, 6, 3, 7, 4, 1, 4, 2, 4, 3, 4, 4, 4, 5, 4, 6, 4, 7, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 6, 2, 6, 3, 6, 5, 6, 6};
	private final byte[] CHAR_x = {2, 1, 2, 2, 2, 5, 2, 6, 3, 2, 3, 3, 3, 4, 3, 5, 4, 3, 4, 4, 5, 2, 5, 3, 5, 4, 5, 5, 6, 1, 6, 2, 6, 5, 6, 6};
	private final byte[] CHAR_y = {2, 1, 2, 2, 2, 5, 2, 6, 3, 1, 3, 2, 3, 5, 3, 6, 4, 1, 4, 2, 4, 5, 4, 6, 5, 2, 5, 3, 5, 4, 5, 5, 5, 6, 6, 4, 6, 5, 7, 1, 7, 2, 7, 3, 7, 4};
	private final byte[] CHAR_z = {2, 1, 2, 2, 2, 3, 2, 4, 2, 5, 2, 6, 3, 4, 3, 5, 4, 3, 4, 4, 5, 2, 5, 3, 6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6, 6};
	private final byte[] CHAR_LINE = {0, 3, 0, 4, 1, 3, 1, 4, 2, 3, 2, 4, 3, 3, 3, 4, 4, 3, 4, 4, 5, 3, 5, 4, 6, 3, 6, 4, 7, 3, 7, 4};
	private boolean[][] display = this.parseTo8BitMatrix("Here");
	private int scroll = 0;
	
	//scrolls display
	public void scroll() {
		if(this.display[0].length > 32) {
			this.scroll = (this.scroll < this.display[0].length) ? this.scroll + 1 : 1;
		}
	}
	
	//sets the clock's display
	public void setDisplay(String s) {
		this.display = this.parseTo8BitMatrix(s);
	}
	
	//determines the current frame of the clock
	private boolean[][] currentFrame() {
		boolean[][] currentFrame = new boolean[8][32];
		int length = this.display[0].length;
		if(length == 32) { //do nothing
			currentFrame =  this.display;
		} else if(length <= 24) { //center
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < length; j++) {
					currentFrame[i][j+((32-length)/2)] = this.display[i][j];
				}
			}
			this.display = currentFrame; //set display to currentFrame so the display doesn't get centered each time
		} else { //scroll
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 32; j++) {
					currentFrame[i][j] = (this.scroll + j < length) ? this.display[i][j+this.scroll] : this.display[i][j+this.scroll-length];
				}
			}
		}
		return currentFrame;
	}
	
	//renders clock to screen using currentFrame()
	public void render(Graphics g) {
		g.setColor(Color.white);
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 32; j++) {
				if(this.currentFrame()[i][j] == true) {
					g.fillRect(j, i, 1, 1);
				}
			}
		}
	}
	
	//turns string into [8][8*s.length()] boolean matrix
	//Available characters: !@#$%^&*()<>_+=-[]:;/.,\"\\|' abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ
	private boolean[][] parseTo8BitMatrix(String s) {
		boolean[][] result = new boolean[8][(8*s.length())];
		for(int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
			case ' ': //do nothing
				break;
			case '!': this.append(CHAR_EXCLAMATION, i, result);
			    break;
			case '"': this.append(CHAR_DOUBLEQUOTE, i, result);
			    break;
			case '#': this.append(CHAR_HASHTAG, i, result);
			    break;
			case '$': this.append(CHAR_DOLLARSIGN, i, result);
			    break;
			case '%': this.append(CHAR_PERCENT, i, result);
			    break;
			case '&': this.append(CHAR_AND, i, result);
			    break;
			case '\'': this.append(CHAR_SINGLEQUOTE, i, result); //'
			    break;
			case '(': this.append(CHAR_OPENBRACE, i, result);
			    break;
			case ')': this.append(CHAR_CLOSEBRACE, i, result);
			    break;
			case '*': this.append(CHAR_STAR, i, result);
			    break;
			case '+': this.append(CHAR_PLUS, i, result);
			    break;
			case ',': this.append(CHAR_COMMA, i, result);
			    break;
			case '-': this.append(CHAR_DASH, i, result);
			    break;
			case '.': this.append(CHAR_PERIOD, i, result);
			    break;
			case '/': this.append(CHAR_FORWARDSLASH, i, result);
			    break;
			case '0': this.append(CHAR_0, i, result);
			    break;
			case '1': this.append(CHAR_1, i, result);
			    break;
			case '2': this.append(CHAR_2, i, result);
			    break;
			case '3': this.append(CHAR_3, i, result);
			    break;
			case '4': this.append(CHAR_4, i, result);
			    break;
			case '5': this.append(CHAR_5, i, result);
			    break;
			case '6': this.append(CHAR_6, i, result);
			    break;
			case '7': this.append(CHAR_7, i, result);
			    break;
			case '8': this.append(CHAR_8, i, result);
			    break;
			case '9': this.append(CHAR_9, i, result);
			    break;
			case ':': this.append(CHAR_COLON, i, result);
			    break;
			case ';': this.append(CHAR_SEMICOLON, i, result);
			    break;
			case '<': this.append(CHAR_OPENARROW, i, result);
			    break;
			case '=': this.append(CHAR_EQUALS, i, result);
			    break;
			case '>': this.append(CHAR_CLOSEARROW, i, result);
			    break;
			case '?': this.append(CHAR_QUESTIONMARK, i, result);
			    break;
			case '@': this.append(CHAR_AT, i, result);
			    break;
			case 'A': this.append(CHAR_A, i, result);
			    break;
			case 'B': this.append(CHAR_B, i, result);
			    break;
			case 'C': this.append(CHAR_C, i, result);
			    break;
			case 'D': this.append(CHAR_D, i, result);
			    break;
			case 'E': this.append(CHAR_E, i, result);
			    break;
			case 'F': this.append(CHAR_F, i, result);
			    break;
			case 'G': this.append(CHAR_G, i, result);
			    break;
			case 'H': this.append(CHAR_H, i, result);
			    break;
			case 'I': this.append(CHAR_I, i, result);
			    break;
			case 'J': this.append(CHAR_J, i, result);
			    break;
			case 'K': this.append(CHAR_K, i, result);
			    break;
			case 'L': this.append(CHAR_L, i, result);
			    break;
			case 'M': this.append(CHAR_M, i, result);
			    break;
			case 'N': this.append(CHAR_N, i, result);
			    break;
			case 'O': this.append(CHAR_O, i, result);
			    break;
			case 'P': this.append(CHAR_P, i, result);
			    break;
			case 'Q': this.append(CHAR_Q, i, result);
			    break;
			case 'R': this.append(CHAR_R, i, result);
			    break;
			case 'S': this.append(CHAR_S, i, result);
			    break;
			case 'T': this.append(CHAR_T, i, result);
			    break;
			case 'U': this.append(CHAR_U, i, result);
			    break;
			case 'V': this.append(CHAR_V, i, result);
			    break;
			case 'W': this.append(CHAR_W, i, result);
			    break;
			case 'X': this.append(CHAR_X, i, result);
			    break;
			case 'Y': this.append(CHAR_Y, i, result);
			    break;
			case 'Z': this.append(CHAR_Z, i, result);
			    break;
			case '[': this.append(CHAR_OPENSQUAREBRACE, i, result);
			    break;
			case '\\': this.append(CHAR_BACKSLASH, i, result); //\
			    break;
			case ']': this.append(CHAR_CLOSESQUAREBRACE, i, result);
			    break;
			case '^': this.append(CHAR_POWER, i, result);
			    break;
			case '_': this.append(CHAR_UNDERSCORE, i, result);
			    break;
			case 'a': this.append(CHAR_a, i, result);
			    break;
			case 'b': this.append(CHAR_b, i, result);
			    break;
			case 'c': this.append(CHAR_c, i, result);
			    break;
			case 'd': this.append(CHAR_d, i, result);
			    break;
			case 'e': this.append(CHAR_e, i, result);
			    break;
			case 'f': this.append(CHAR_f, i, result);
			    break;
			case 'g': this.append(CHAR_g, i, result);
			    break;
			case 'h': this.append(CHAR_h, i, result);
			    break;
			case 'i': this.append(CHAR_i, i, result);
			    break;
			case 'j': this.append(CHAR_j, i, result);
			    break;
			case 'k': this.append(CHAR_k, i, result);
			    break;
			case 'l': this.append(CHAR_l, i, result);
			    break;
			case 'm': this.append(CHAR_m, i, result);
			    break;
			case 'n': this.append(CHAR_n, i, result);
			    break;
			case 'o': this.append(CHAR_o, i, result);
			    break;
			case 'p': this.append(CHAR_p, i, result);
			    break;
			case 'q': this.append(CHAR_q, i, result);
			    break;
			case 'r': this.append(CHAR_r, i, result);
			    break;
			case 's': this.append(CHAR_s, i, result);
			    break;
			case 't': this.append(CHAR_t, i, result);
			    break;
			case 'u': this.append(CHAR_u, i, result);
			    break;
			case 'v': this.append(CHAR_v, i, result);
			    break;
			case 'w': this.append(CHAR_w, i, result);
			    break;
			case 'x': this.append(CHAR_x, i, result);
			    break;
			case 'y': this.append(CHAR_y, i, result);
			    break;
			case 'z': this.append(CHAR_z, i, result);
			    break;
			case '|': this.append(CHAR_LINE, i, result);
			    break;
			default: System.out.println("UNDEFINED CHAR");
				break;
			}
		}
		return result;
	}
	
	//uses indices from charData to append on display from offset n
	private void append(byte[] charData, int n, boolean[][] display) {
		//size of each letter
		n*=8;
		//append
		for(int i = 0; i < (charData.length/2); i++) {
			display[charData[2*i]][charData[(2*i)+1]+n] = true;
		}
	}
}
