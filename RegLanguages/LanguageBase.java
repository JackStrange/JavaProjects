import java.util.ArrayList;
public class LanguageBase{
	
	public class Regex{
		public String regex;

		public static NFAE toNFAE(Regex regex){

		}
		public static NFA toNFA(Regex regex){
			NFAE.toNFA(toNFAE(regex));
		}
		public static DFA toDFA(Regex regex){
			NFA.toDFA(toNFA(regex));
		}
	}
	public class TransFunc{
		public Integer start;
		public Character symbol;
		public Integer end;
	}
	public abstract class Automaton{
		public ArrayList<Integer> states;
		public Integer start;
		public ArrayList<Integer> accepting;
		public ArrayList<TransFunc> delta;
	}
	public class DFA extends Automaton{
		public static Regex toRegex(DFA dfa){
			
		}
		public static NFAE toNFAE(DFA dfa){
			Regex.toNFAE(toRegex(dfa));
		}
		public static NFA toNFA(DFA dfa){
			NFAE.toNFA(toNFAE(dfa));
		}
	}
	public class NFA extends Automaton{
		public static DFA toDFA(NFA nfa){

		}
		public static Regex toRegex(NFA nfa){
			DFA.toRegex(toDFA(nfa));
		}
		public static NFAE toNFAE(NFA nfa){
			Regex.toNFAE(toRegex(nfa));
		}
	}
	public class NFAE extends Automaton{
		public static NFA toNFA(NFAE nfae){

		}
		public static DFA toDFA(NFAE nfae){
			NFA.toDFA(toNFA(nfae));
		}
		public static Regex toRegex(NFAE nfae){
			DFA.toRegex(toDFA(nfae));
		}
	}
}