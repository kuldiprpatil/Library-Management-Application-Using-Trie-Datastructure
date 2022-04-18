package com.app.trie;

import java.util.LinkedList;
import java.util.List;

public class Trie {

	  static TrieNode root = new TrieNode(' ');
	 
	                                      //============Insert Operation =========================//
	    //Insert Element in trie datastructure.
			public void insert(String word) {
				//set node is equal to root
				 TrieNode node = root;
				
				 for (char ch : word.toCharArray()) {
				     
					 if (!node.children.containsKey(ch)) 
				         node.children.put(ch, new TrieNode(ch));			     
				     node = node.children.get(ch);			      		    			    	 			     
				 }
				 //set node word as true.
				 node.isEnd = true;	
			}
			 
			
			
	       //=================Search Operation===============================//
		   	//helper method for search operation.
			protected boolean Search(String prefix, boolean exact) {
				//set last Node as root.
		        TrieNode lastNode = root;
		        for (char c : prefix.toCharArray()) {
		            lastNode = lastNode.children.get(c);
		            
		            if (lastNode == null)
		                return false;
		        }
		       
		        return (!exact || lastNode.isEnd);
		    }
		 
			//Search method to find word in trie
		    public boolean search(String prefix) {
		        return Search(prefix, false);
		    }
			
			
		   
		   //=============================================Delete Operation=====================================//
		   
		    public void delete(String word) {
		        delete(root, word, 0);
		    }
           
		    //helper function to delete element.
		    private boolean delete(TrieNode current, String word, int index) {
		        
		    	if (index == word.length()) {
		    		//current end is false means no alphabet at current.
		            if (!current.isEnd) {
		                return false;
		            }
		            current.isEnd = false;
		            return current.children.isEmpty();
		        }
		    	
		    	//set ch at particular word of index.
		        char ch = word.charAt(index);
		        TrieNode node = current.children.get(ch);
		        if (node == null) {
		            return false;
		        }
		        
		        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEnd;

		        if (shouldDeleteCurrentNode) {
		            current.children.remove(ch);
		            return current.children.isEmpty();
		        }
		        return false;
		    }
			
			
		 
		    //===============================Suggestion Operation========================================================//
			
			
	          //find all word with given prefix
	       public List<String> autocomplete(String prefix) {
				 List<String> res = new LinkedList<String>();	     
				 TrieNode node = root;
				 for (char ch : prefix.toCharArray()) {
					 if (node.children.containsKey(ch)) 
				         node = node.children.get(ch);
				     else 
				    	 return res;			     
				 }
				 helper(node, res, prefix.substring(0, prefix.length()-1));
				 return res;
			}
			
			// recursive function called by autocomplete
		  private void helper(TrieNode node, List<String> res, String prefix) {
				 if (node.isEnd) 
					 res.add(prefix + node.data);
				 for (Character ch : node.children.keySet()) 
				     helper(node.children.get(ch), res, prefix + node.data);
			}
		}


