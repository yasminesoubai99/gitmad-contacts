package edu.gatech.gtorg.gitmad.contacts.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.gtorg.gitmad.contacts.R;
import edu.gatech.gtorg.gitmad.contacts.adapters.ContactsAdapter;
import edu.gatech.gtorg.gitmad.contacts.models.Contact;


public class ContactListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ContactsAdapter adapter;

    private SearchView searchView;

    private List<Contact> contacts;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.rvContacts);
        searchView = view.findViewById(R.id.searchView);

        contacts = loadData();

        adapter = new ContactsAdapter(contacts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                // We don't care about submit since we're filtering  in onChange.
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // TODO: Filter
                return false;
            }
        });
    }

    private List<Contact> loadData() {
        // TODO: Load data from Room
        return new ArrayList<>();
    }
}